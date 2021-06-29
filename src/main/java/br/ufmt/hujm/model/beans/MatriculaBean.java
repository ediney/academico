package br.ufmt.hujm.model.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufmt.hujm.model.entities.Matricula;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@ManagedBean
@RequestScoped
public class MatriculaBean {
	
	private Matricula matricula = new Matricula();

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
}
