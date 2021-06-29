package br.ufmt.hujm.test;

import br.ufmt.hujm.model.dao.CursoDAO;
import br.ufmt.hujm.model.dao.InstituicaoDAO;
import br.ufmt.hujm.model.dao.TurmaDAO;
import br.ufmt.hujm.model.entities.Curso;
import br.ufmt.hujm.model.entities.Instituicao;
import br.ufmt.hujm.model.entities.Turma;
import br.ufmt.hujm.util.HibernateUtil;

/**
 * CLASSE DE TESTE TABELATEST
 * Testes para criar/atualizar as tabelas e verificar se a persistencia esta funcionando corretamente.
 * 
 * @author Ediney Lopes
 * 
 */

public class TabelaTest {
	
	public static void main(String[] args) {
		 //Atualiza o banco
		 HibernateUtil.getFabricaDeSessoes();
		 
		 //Salva uma instituicao
		 InstituicaoDAO instituicaoDAO = new InstituicaoDAO();
		 Instituicao instituicao = new Instituicao("UFMT");
		 instituicaoDAO.salvar(instituicao);
		 
		 //Salva um curso
		 CursoDAO cursoDAO = new CursoDAO();
		 Curso curso = new Curso("BIOLOGIA");
		 cursoDAO.salvar(curso);
		 
		 //Salva uma turma
		 TurmaDAO turmaDAO = new TurmaDAO();
		 Turma turma = new Turma("2015-2");
		 turmaDAO.salvar(turma);		 
		 
	}

}
