package br.ufmt.hujm.converters;

import javax.faces.convert.FacesConverter;

import br.ufmt.hujm.model.entities.Curso;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@FacesConverter("localonverter")
public class LocalConverter extends EntityConverter<Curso>{

	public LocalConverter() {
		super(Curso.class);
	}

}
