package br.ufmt.hujm.model.entities;

import javax.persistence.NamedQuery;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public @interface NamedQueries {

	NamedQuery[] value();

}
