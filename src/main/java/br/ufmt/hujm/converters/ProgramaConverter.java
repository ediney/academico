
package br.ufmt.hujm.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufmt.hujm.model.entities.Programa;
import br.ufmt.hujm.repository.ProgramaRepository;
import br.ufmt.hujm.util.CDIServiceLocator;

/**
 * 
 * @author Ediney Lopes
 * 
 */
@FacesConverter(value = "programaConverter",forClass = Programa.class)
public class ProgramaConverter implements Converter{
    
    private ProgramaRepository programaRepository;

    public ProgramaConverter() {
        programaRepository = CDIServiceLocator.getBean(ProgramaRepository.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
    	Programa retorno = null;
        if (value != null) {
            //Long id = new Long(value);
            retorno = programaRepository.guardar(null);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
        	Programa programa = (Programa) value;
            return programa.getIdPrograma() == null ? null : programa.getIdPrograma().toString();
        }

        return "";

    }
    
}
