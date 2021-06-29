
package br.ufmt.hujm.filters;

import java.io.Serializable;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public class ProgramaFilter implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
       
}
