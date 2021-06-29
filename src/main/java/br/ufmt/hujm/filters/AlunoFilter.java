package br.ufmt.hujm.filters;

import java.io.Serializable;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public class AlunoFilter implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nome;
    private String curso;
    private String turma;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurno() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

}
