package br.ufmt.hujm.service;

import java.util.List;

import br.ufmt.hujm.model.entities.Aluno;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public interface AlunoService {

	public void salvar(Aluno aluno);
	public List<Aluno> listarTodos();
	public Aluno obterPorRGA(String rga);
}
