package TesteEntityManagerUtil;
import org.junit.Test;
import util.EntityManagerUtil;

/* Este teste faz conex�o testando o driver do banco HSQLDB
 * e se n�o existir as tabelas do banco ele constroi e 
 * testa tambem as entidades mapeadas.
 */

public class TesteEntityManagerUtil {
	
	@Test
	public void connectionTest() {
		
		EntityManagerUtil.getEntityManager();
		
	}		

}