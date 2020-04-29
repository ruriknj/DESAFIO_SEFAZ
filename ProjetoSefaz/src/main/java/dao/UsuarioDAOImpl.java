package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import entidade.Usuario;
import util.EntityManagerUtil;


public class UsuarioDAOImpl implements UsuarioDAO {

	private EntityManager ent;

	public UsuarioDAOImpl(EntityManager ent) {
		this.ent = ent;
	}

	public boolean inserir(Usuario usuario) {

		try {

			EntityTransaction tx = ent.getTransaction();
			tx.begin();

			ent.persist(usuario);
			tx.commit();

			System.out.println("Usuario salvo com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();

			ent.getTransaction().rollback();
			ent.close();
			ent.getEntityManagerFactory();

		}
		return true;

	}

	public void alterar(Usuario usuario) {

		try {

			EntityTransaction tx = ent.getTransaction();
			tx.begin();

			ent.merge(usuario);
			tx.commit();

		} catch (Exception e) {
			ent.getTransaction().rollback();
			ent.close();
			ent.getEntityManagerFactory();
		}

	}

	public void remover(Usuario usuario) {

		try {

			EntityTransaction tx = ent.getTransaction();
			tx.begin();

			ent.remove(usuario);
			tx.commit();

		} catch (Exception e) {

			ent.getTransaction().rollback();
			ent.close();
			ent.getEntityManagerFactory();

		}

	}

	public Usuario pesquisar(String email) {

		Usuario usuario = ent.find(Usuario.class, email);

		return usuario;

	}

	public List<Usuario> listarUsuarios() {

		Query query = ent.createQuery("from Usuario u");

		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = query.getResultList();

		return usuarios;
	}

	public Usuario getName(Usuario usuario) {

		System.out.println("lista user inputs 4: " + usuario);

		EntityManager em = EntityManagerUtil.getEntityManager();

		String hql = "SELECT u from Usuario u WHERE u.nome = :usuarioAdm AND u.senha = :senhaAdm";

		Query query = em.createQuery(hql);

		query.setParameter("usuarioAdm", usuario.getNome());
		query.setParameter("senhaAdm", usuario.getSenha());

		System.out.println("Lista de users:" + query.getSingleResult());

		return (Usuario) query.getSingleResult();

	}

}
