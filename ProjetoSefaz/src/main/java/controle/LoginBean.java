package controle;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import dao.UsuarioDAO;
import dao.UsuarioDAOImpl;
import entidade.Usuario;
import util.EntityManagerUtil;

@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {

	private String usarioAdmin = "admin";
	private String senhaAdmin = "admin";

	private String usuarioAdm;
	private String senhaAdm;

	private String usuarioNovo;
	private String senhaNovo;

	private static final String PESQUISAR = "pesquisarUsuario.xhtml";
	private UsuarioDAO usuarioDAO;
	private String mensagem;

	
	public LoginBean() {
		
		this.usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getEntityManager());
	}

	public void entrar() throws IOException {

		if (this.usuarioAdm.equals(this.usarioAdmin) && this.senhaAdm.equals(this.senhaAdmin))

		{
			FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);

		} else {

			Usuario usuarioPesquisa = this.usuarioDAO.pesquisar(this.usuarioAdm);

			if (usuarioPesquisa != null) {
				
				if (usuarioPesquisa.getSenha().equals(this.senhaAdm)) {
					FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
					
				} else {
					this.mensagem = "Usuario, senha errada";
				}
			} else {
				this.mensagem = "Usuario, não existe";
			}

		}
	}

	public String getUsuarioNovo() {
		return usuarioNovo;
	}

	public void setUsuarioNovo(String usuarioNovo) {
		this.usuarioNovo = usuarioNovo;
	}

	public String getSenhaNovo() {
		return senhaNovo;
	}

	public void setSenhaNovo(String senhaNovo) {
		this.senhaNovo = senhaNovo;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
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
	
	
}
