package br.ufmt.hujm.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public class JpaUtil {
	
	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("AcademicoPU");
	}
	
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
}
