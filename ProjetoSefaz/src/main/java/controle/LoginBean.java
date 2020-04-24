package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import dao.UsuarioDAOImpl;
import entidade.Usuario;
import util.EntityManagerUtil;

@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {

	Usuario usuario = new Usuario();

	private String usarioAdmin = "admin";
	private String senhaAdmin = "admin";
	private String usuarioAdm = "";
	private String senhaAdm = "";
	private UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getEntityManager());
	private static final String PESQUISAR = "pesquisarUsuario.xhtml";
	// private UsuarioDAO usuarioDAO;

	private String mensagem;

	public LoginBean() {

	}

	@SuppressWarnings("unused")
	public void entrar() {

		this.usuario.setNome(usuarioAdm);
		this.usuario.setSenha(senhaAdm);

		try {

			if (this.usuarioAdm.equals(this.usarioAdmin) && this.senhaAdm.equals(this.senhaAdmin))

				FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
			else {

				this.mensagem = "logado com sucesso";

				Usuario usuarioPesquisa = this.usuarioDAO.getName(this.usuario);

				FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
			}

		} catch (Exception e) {
			this.mensagem = "Usuario ou senha errada";

		}
	}

	public String getUsuarioAdm() {
		return usuarioAdm;
	}

	public void setUsuarioAdm(String usuarioAdm) {
		this.usuarioAdm = usuarioAdm;
	}

	public String getSenhaAdm() {
		return senhaAdm;
	}

	public void setSenhaAdm(String senhaAdm) {
		this.senhaAdm = senhaAdm;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
