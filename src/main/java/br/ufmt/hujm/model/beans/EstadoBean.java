package br.ufmt.hujm.model.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufmt.hujm.model.entities.Estado;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@ManagedBean
@RequestScoped
public class EstadoBean {
	
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
