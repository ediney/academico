package br.ufmt.hujm.util;

import javax.persistence.Persistence;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public class CriarTabelas {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("AcademicoPU");
	}
}
