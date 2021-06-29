package br.ufmt.hujm.test;

import br.ufmt.hujm.model.entities.Aluno;

public class AlunoTest {
	
	public static void main(String[] args) {
	    Aluno aluno = new Aluno();
	    
	    // podemos chamar métodos da Pessoa:
	    aluno.setNome("João da Silva");
	    
	    // e também métodos do Aluno
	    aluno.setRegistroGEP("12345");
	  }
}