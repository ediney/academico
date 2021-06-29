package br.ufmt.hujm.filters;

import java.io.Serializable;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public class CursoFilter implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
