package dao;

import java.util.List;
import entidade.Usuario;

public interface UsuarioDAO {

	public boolean inserir(Usuario usuario);

	public void alterar(Usuario usuario);

	public void remover(Usuario usuario);

	public Usuario pesquisar(String email);

	public List<Usuario> listarUsuarios();

	public Usuario getName(Usuario usuario);
	
	

}
