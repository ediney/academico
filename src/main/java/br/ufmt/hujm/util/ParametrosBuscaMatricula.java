package br.ufmt.hujm.util;

import java.util.Date;
import java.util.List;

import br.ufmt.hujm.model.entities.Aluno;
import br.ufmt.hujm.model.entities.Curso;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public class ParametrosBuscaMatricula {

	private Aluno aluno;
	private List<Curso> cursos;
	private Date dataInicial;
	private Date dataFinal;

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

}
