package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
* @author Rurik
* Verifica a conexão com o banco de dados HSQLDB.
*
*/

public class EntityManagerUtil {
		
		private static EntityManagerFactory entityManagerFactory;
		private static EntityManager entityManager;
		
		public static EntityManager getEntityManager() {
			
			if(entityManager == null) {
				
				entityManagerFactory = Persistence.createEntityManagerFactory("sefaz");
				entityManager = entityManagerFactory.createEntityManager();
			}
			return entityManager;
			
		}

	}


		
		
	

