package org.travelplan.messagesource;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public class MessagesSource implements MessageSourceAware{
	
	private MessageSource messageSource;
	private static Locale locale;
	
	public MessagesSource() {
		locale = Locale.getDefault();
	}
	
	/*Spring will automatically inject the MessageSource into the 
	class via MessageSourceAware implementation */
	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public String getLocaleValue(String propValue, Object[] args) {
		return messageSource.getMessage(propValue, args, locale);
	}
	
}
