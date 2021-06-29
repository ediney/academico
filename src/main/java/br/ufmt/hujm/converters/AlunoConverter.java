
package br.ufmt.hujm.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufmt.hujm.model.entities.Aluno;
import br.ufmt.hujm.repository.AlunoRepository;
import br.ufmt.hujm.util.CDIServiceLocator;

/** Conversor de tipo objeto/string para Aluno
 * 
 * @author Ediney Lopes
 * 
 */
@FacesConverter(forClass = Aluno.class)
public class AlunoConverter implements Converter{    
    
    private AlunoRepository alunoRepository;

    public AlunoConverter() {
        alunoRepository = CDIServiceLocator.getBean(AlunoRepository.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Aluno retorno = null;
        if (value != null) {
            Long id = new Long(value);
            retorno = alunoRepository.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Aluno aluno = (Aluno) value;
            return aluno.getIdPessoa() == null ? null : aluno.getIdPessoa().toString();
        
        }

        return "";

    }
    
}
