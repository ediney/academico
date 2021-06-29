package br.ufmt.hujm.converters;

import javax.faces.convert.FacesConverter;

import br.ufmt.hujm.model.entities.Curso;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@FacesConverter("cursoConverter")
public class CursoConverter extends EntityConverter<Curso>{

	public CursoConverter() {
		super(Curso.class);
	}

}
