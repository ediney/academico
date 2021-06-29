package br.ufmt.hujm.service;

import java.util.List;

import br.ufmt.hujm.model.entities.Turma;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public interface TurmaService {

	public void salvar(Turma turma);
	public List<Turma> listarTodas();
}
