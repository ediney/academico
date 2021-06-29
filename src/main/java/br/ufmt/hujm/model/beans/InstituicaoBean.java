package br.ufmt.hujm.model.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufmt.hujm.model.entities.Instituicao;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@ManagedBean
@RequestScoped
public class InstituicaoBean {
	
	private Instituicao instituicao = new Instituicao();

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
}
