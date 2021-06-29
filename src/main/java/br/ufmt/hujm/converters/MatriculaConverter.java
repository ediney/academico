package br.ufmt.hujm.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufmt.hujm.model.entities.Aluno;
import br.ufmt.hujm.model.entities.Curso;
import br.ufmt.hujm.model.entities.Matricula;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@FacesConverter("matriculaConverter")
public class MatriculaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String valor) {
		if(valor.equals("") || !valor.contains("#")){
			return null;
		}
		
		Matricula matricula = new Matricula();
		
		String[] propriedades = valor.split("#");
		if(!propriedades[0].isEmpty()){
			matricula.setIdMatricula(new Integer(propriedades[0]));
		}
		if(!propriedades[1].isEmpty()){
			Curso curso = new Curso();
			curso.setNome(propriedades[1]);
			matricula.setCurso(curso);
		}
		if(!propriedades[2].isEmpty()){
			Aluno aluno = new Aluno();
			aluno.setNome(propriedades[2]);
			matricula.setAluno(aluno);
		}
		
		return matricula;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object obj) {
		if(obj == null || !(obj instanceof Matricula)){
			return "";
		}
		
		Matricula matricula = (Matricula) obj;
		
		String id = matricula.getRga() == null ? "" : matricula.getRga().toString();
		String nomeCurso = matricula.getCurso() == null
				|| matricula.getCurso().getNome() == null ? "" : matricula.getCurso().getNome();
		//String nomeAluno = matricula.getAluno() == null
		//		|| matricula.getAluno().getNome(null) == null ? "" : matricula.getAluno().getNome(nomeAluno);
		
		return id + "#" + nomeCurso + "#"; //+ nomeAluno;
	}

}
