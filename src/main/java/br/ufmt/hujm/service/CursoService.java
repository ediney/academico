package br.ufmt.hujm.service;

import java.util.List;

import br.ufmt.hujm.model.entities.Curso;

/**
 * 
 * @author Ediney Lopes
 * 
 */
public interface CursoService {

	public void salvar(Curso curso);
	public List<Curso> listarTodos();
	public void excluir(Curso curso);
}
