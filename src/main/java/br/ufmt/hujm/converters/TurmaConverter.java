
package br.ufmt.hujm.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufmt.hujm.model.entities.Turma;
import br.ufmt.hujm.repository.TurmaRepository;
import br.ufmt.hujm.util.CDIServiceLocator;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@FacesConverter(value = "turmaConverter",forClass = Turma.class)
public class TurmaConverter implements Converter {
    
    private TurmaRepository turmaRepository;

    public TurmaConverter() {
        turmaRepository = CDIServiceLocator.getBean(TurmaRepository.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Turma retorno = null;
        if (value != null) {
            Long id = new Long(value);
            retorno = turmaRepository.porIdTurma(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Turma turma = (Turma) value;
            return turma.getIdTurma() == null ? null : turma.getIdTurma().toString();
        }

        return "";

    }
    
}
