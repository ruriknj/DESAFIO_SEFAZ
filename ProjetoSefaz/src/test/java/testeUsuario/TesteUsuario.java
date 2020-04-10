package testeUsuario;

import dao.UsuarioDAOImpl;

import java.util.ArrayList;
import java.util.List;

import entidade.Telefone;
import entidade.Usuario;
import util.EntityManagerUtil;

public class TesteUsuario {

	public static void main(String[] args) {

		// salvarTest();
		pesquisarTest();
		// removerTest();
		// alterarTest();
	}

	static Usuario user = new Usuario();
	static Telefone tel = new Telefone();
	static List<Usuario> listaUsuario;
	static String emailSelecionado;

	static UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getEntityManager());

	public static void salvarTest() {

		listaUsuario = usuarioDAO.listarTodos();
		listaUsuario = new ArrayList<Usuario>();
		user.setTelefones(new ArrayList<Telefone>());
		// user = usuarioDAO.pesquisar(emailSelecionado);

		tel.setDdd(21);
		tel.setNumero("533443");
		tel.setTipo("CELULAR");
		tel.setUsuario(user);
		user.getTelefones().add(tel);

		user.setNome("micolau");
		user.setSenha("1234567");
		user.setEmail("ruriknj@com");

		usuarioDAO.inserir(user);
		
		System.out.println("Lista de usuários: " + listaUsuario);
	}
	
	public static void pesquisarTest() {

		listaUsuario = usuarioDAO.listarTodos();
		System.out.println("Entrou PEsquisar ====");
		System.out.println(listaUsuario);
	}

	public static void removerTest() {

		user = usuarioDAO.pesquisar("nick@com");
		usuarioDAO.remover(user);

		listaUsuario = usuarioDAO.listarTodos();
		System.out.println("Lista de usuários: " + listaUsuario);
		System.out.println(listaUsuario);
		
	}

	public static void alterarTest() {

		listaUsuario = usuarioDAO.listarTodos();
		listaUsuario = new ArrayList<Usuario>();
		user.setTelefones(new ArrayList<Telefone>());

		tel.setDdd(11);
		tel.setNumero("123456789");
		tel.setTipo("Celular");
		tel.setUsuario(user);
		user.getTelefones().add(tel);

		user.setNome("rurik123");
		user.setSenha("12345678787");
		user.setEmail("rurikn123j@com");

		usuarioDAO.alterar(user);
		
		System.out.println(listaUsuario);
	}

}
