package testeUsuario;

import dao.UsuarioDAO;


import dao.UsuarioDAOImpl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.jpa.internal.EntityManagerImpl;
import entidade.Telefone;
import entidade.Usuario;
import util.EntityManagerUtil;

public class TesteUsuario {

	public static void main(String[] args) {

		// salvarTest();
		// removerTest();
		// alterarTest();
		pesquisarTest();
		// pesquisarIdTest36);
		//listarTelefonesTest();

	}

	static Usuario user = new Usuario();
	static Telefone tel = new Telefone();
	static List<Usuario> listaUsuario;
	static List<Telefone> telefones;
	// static String emailSelecionado;

	static UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getEntityManager());
	static UsuarioDAO dao = new UsuarioDAOImpl(EntityManagerUtil.getEntityManager());

	public static void salvarTest() {

		tel.setDdd(21);
		tel.setNumero("55455533");
		tel.setTipo("CELULAR");
		tel.setUsuario(user);
		user.getTelefones().add(tel);

		user.setNome("teste3434");
		user.setSenha("teste3434");
		user.setEmail("teste3434@com.br");

		// usuarioDAO.inserir(user);
		usuarioDAO.alterar(user);

		System.out.println("Lista de usuários completa: " + listaUsuario);
	}

	public static void pesquisarTest() {

		listaUsuario = usuarioDAO.listarUsuarios();
		System.out.println("Entrou PEsquisar ====");
		System.out.println(listaUsuario);

	}

	public static void removerTest() {

		user = usuarioDAO.pesquisar("teste10@com");
		usuarioDAO.remover(user);

		listaUsuario = usuarioDAO.listarUsuarios();
		System.out.println("Lista de usuários: " + listaUsuario);
		System.out.println(listaUsuario);

	}

	public static void alterarTest() {

		tel.setDdd(11);
		tel.setNumero("343434");
		tel.setTipo("Celular");
		tel.setUsuario(user);
		user.getTelefones().add(tel);

		user.setNome("rurik3434");
		user.setSenha("3434");
		user.setEmail("rurikn3434j@com");

		usuarioDAO.alterar(user);

		System.out.println("LISTA COMPLETA: " + listaUsuario);
	}

	public static void primeirasConsultas(EntityManagerImpl entityManager) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sefaz");
		EntityManager entityManager1 = entityManagerFactory.createEntityManager();

		String jpql = "select u from Usuario u";
		TypedQuery<Usuario> typedQuery = entityManager1.createQuery(jpql, Usuario.class);
		List<Usuario> lista = typedQuery.getResultList();
		lista.forEach(u -> System.out.println(u.getNome()));

		System.out.println(lista.size());

		for (Usuario user : lista) {

			System.out.println("Lista de usuarios e e-mails: " + user.getNome());
		}
	}

	public static void listarTelefonesTest() {

		Query query = EntityManagerUtil.getEntityManager().createQuery("from Telefone t");

		@SuppressWarnings("unchecked")
		List<Telefone> telefones = query.getResultList();

		System.out.println(telefones);

	}

}
