package br.ufmt.hujm.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** ENTIDADE ESTAGIO/ATIVIDADE
 * - Responsavel por armazenar os dados referentes a estagios e atividades
 * 
 * @author Ediney Lopes
 * 
 */
@Entity
@Table(name = "estagios_atividades")
public class EstagioAtividade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idEstagioAtividade;
	private String descricao;
	
	private Curso curso;
	
	private Set <Programa> programas = new HashSet<Programa>(0);
	
	private Date dataInicio;
	private Date dataTermino;
	
	private boolean matutino;
	private boolean vespertino;
	private boolean noturno;
	
	private DiaSemana[] dias;
	
	private boolean biblioteca;
	private boolean estacionamento;
	
	private Local idLocal;
	
	@Id
	@GeneratedValue
	public Long getIdEstagioAtividade() {
		return idEstagioAtividade;
	}
	
	public void setIdEstagioAtividade(Long idEstagioAtividade) {
		this.idEstagioAtividade = idEstagioAtividade;
	}
	
	@Column(length = 120, nullable = false)
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/* Relacionamento Muitos-Para-Um
	 * Muitos estagios e atividades pertencem a um curso em especifico
	 */
	@ManyToOne
	@JoinColumn(name = "curso_id")
	public Curso getCurso(){
		return curso;
	}
	
	public void setCurso(Curso curso){
		this.curso = curso;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "estagios_atividades")
	public Set <Programa> getProgramas() {
		return programas;
	}

	public void setProgramas(Set <Programa> programas) {
		this.programas = programas;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataTermino() {
		return dataTermino;
	}
	
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	
	/* Metodo que confirma determinado
	 * estagio ou atividade academica
	 * para o periodo da manha.
	 */
	public boolean isMatutino() {
		return matutino;
	}
	
	public void setMatutino(boolean matutino) {
		this.matutino = matutino;
	}
	
	/* Metodo que confirma determinado
	 * estagio ou atividade academica
	 * para o periodo da tarde.
	 */
	public boolean isVespertino() {
		return vespertino;
	}
	
	public void setVespertino(boolean vespertino) {
		this.vespertino = vespertino;
	}
	
	/* Metodo que confirma determinado
	 * estagio ou atividade academica
	 * para o periodo da noite.
	 */
	public boolean isNoturno() {
		return noturno;
	}
	
	public void setNoturno(boolean noturno) {
		this.noturno = noturno;
	}

	/* Metodo que armazena os dias da semana de determinado
	 * estagio ou atividade academica.
	 */
	public DiaSemana[] getDias() {
		return dias;
	}

	public void setDias(DiaSemana[] dias) {
		this.dias = dias;
	}

	/* Metodo que verifica se o aluno matriculado em determinado
	 * estagio ou atividade academica tem direito
	 * ao uso da biblioteca do Hospital
	 */
	public boolean isBiblioteca() {
		return biblioteca;
	}

	public void setBiblioteca(boolean biblioteca) {
		this.biblioteca = biblioteca;
	}

	/* Metodo que verifica se o aluno matriculado em determinado
	 * estagio ou atividade academica tem direito
	 * ao uso do estacionamento do Hospital
	 */
	public boolean isEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(boolean estacionamento) {
		this.estacionamento = estacionamento;
	}
	
	/* Relacionamento Muitos-Para-Um
	 * Muitos estagios e atividades academicos sao realizadas em
	 * um determinado local especifico, em horarios diferentes.
	 */
	@ManyToOne
	@JoinColumn(name = "local_id", nullable = false)
	public Local getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(Local idLocal) {
		this.idLocal = idLocal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEstagioAtividade == null) ? 0 : idEstagioAtividade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstagioAtividade other = (EstagioAtividade) obj;
		if (idEstagioAtividade == null) {
			if (other.idEstagioAtividade != null)
				return false;
		} else if (!idEstagioAtividade.equals(other.idEstagioAtividade))
			return false;
		return true;
	}
}
