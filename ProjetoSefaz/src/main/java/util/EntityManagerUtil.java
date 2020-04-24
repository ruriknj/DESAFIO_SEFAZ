package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static EntityManager getEntityManager() {

		if (entityManager == null) {

			entityManagerFactory = Persistence.createEntityManagerFactory("sefaz");
			entityManager = entityManagerFactory.createEntityManager();

		}

		return entityManager;

	}

}
