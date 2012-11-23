package org.travelplan.validator;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import org.travelplan.messagesource.MessagesSource;

@FacesValidator("org.travelplan.validator.EmailValidator")
public class EmailValidator implements Validator {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
			"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
			"(\\.[A-Za-z]{2,})$";
 
	private Pattern pattern;
	private Matcher matcher;
	private static String invalidEmail;
	
	static {
		if (MessagesSource.getLocale() == Locale.US)
			invalidEmail = "\u2022 Invalid email format";
		else
			invalidEmail = "\u2022 Неверный формат email";		
	}
	
	public EmailValidator(){
		pattern = Pattern.compile(EMAIL_PATTERN);			
	}
 
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
			FacesMessage msg = new FacesMessage("Email validation failed.", invalidEmail);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
}
  