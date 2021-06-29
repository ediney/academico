package br.ufmt.hujm.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/** Validador responsavel por garantir que o email
 *  digitado seja um email valido
 *  
 * @author Ediney Lopes
 * 
 */
@FacesValidator(value="emailValidator")
public class EmailValidator implements Validator {
	
	@Override
	public void validate(FacesContext facesContext, 
			UIComponent uIComponent, Object object) throws ValidatorException {
		
		String enteredEmail = (String)object;
        // Set o padrao do email
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        
        // Combina a string com o padrao
        Matcher m = p.matcher(enteredEmail);
        
        // Checa se outra combinacao funciona
        boolean matchFound = m.matches();
        
        if (!matchFound) {
            FacesMessage message = new FacesMessage();
            message.setDetail("E-mail incorreto!");
            message.setSummary("E-mail incorreto!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}