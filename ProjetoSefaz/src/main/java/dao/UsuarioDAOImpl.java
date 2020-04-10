package dao;

import java.util.List
;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Usuario;


public class UsuarioDAOImpl implements UsuarioDAO {

	private EntityManager ent;

	// Construtor vai receber a conexão para executar
	public UsuarioDAOImpl(EntityManager ent) {
		this.ent = ent;
	}

	public boolean inserir(Usuario usuario) {

		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.persist(usuario);
		tx.commit();

		return true;

	}

	
	public void alterar(Usuario usuario) {

		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.merge(usuario);
		tx.commit();

	}

	public void remover(Usuario usuario) {
		EntityTransaction tx = ent.getTransaction();
		tx.begin();

		ent.remove(usuario);
		tx.commit();

	}

	public Usuario pesquisar(String email) {

		Usuario usuario = ent.find(Usuario.class, email);

		return usuario;

	}

	public List<Usuario> listarTodos() {

		Query query = ent.createQuery("from Usuario u");

		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = query.getResultList();

		return usuarios;

	}

}
