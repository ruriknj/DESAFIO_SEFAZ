package TesteEntityManagerUtil;
import org.junit.Test;
import util.EntityManagerUtil;

/* Este teste faz conexão testando o driver do banco HSQLDB
 * e se não existir as tabelas do banco ele constroi e 
 * testa tambem as entidades mapeadas.
 */

public class TesteEntityManagerUtil {
	
	@Test
	public void connectionTest() {
		
		EntityManagerUtil.getEntityManager();
		
	}		

}