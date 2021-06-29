
package br.ufmt.hujm.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.ufmt.hujm.model.entities.Aluno;
import br.ufmt.hujm.model.entities.Turma;

/** Camada de persistencia no banco de dados
 * 
 * @author Ediney Lopes
 * 
 */
public class TurmaRepository implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private EntityManager manager;   
    
       
    //* guarda no banco de dados
    public Turma guardar(Turma turma) {        
        return manager.merge(turma);

    }

    /*
     *  Metodo que busca uma serie pela descriçao no banco de dados
     *  utilizando JPQL na consulta, mapeando por Entidade
     */
    public Turma porDescricao(String descricao) {
        try {
            return manager.createQuery("from Turma where upper(descricao) = :descricao", Turma.class)
                    .setParameter("descricao", descricao.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    /*
     * Metodo que carrega lista com todas as turmas, é utilizada na tela de cadastro de alunos
     */
    public List<Turma> buscarTurma(){        
        return manager.createQuery("from Serie" , Turma.class).getResultList();
        
    }  

    /*
     * Busca turma por id no banco de dados
     */
    public Turma porIdTurma(Long idTurma) {
        return manager.find(Turma.class, idTurma);
    }

    /*
     * Metodo que pede para o Manager desempacotar a Session do Hibernate, e armazena na variavel session.
     * Depois cria um criterio para entidade Aluno.
     */
    public Turma getAlunosByTurma(Turma turma) {
        Session session = manager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Aluno.class);
         criteria.add(Restrictions.eq("Turma", turma.getIdTurma()));
         Aluno aluno = (Aluno) criteria.uniqueResult();
         return aluno.getIdTurma();                                   
    }    
}
