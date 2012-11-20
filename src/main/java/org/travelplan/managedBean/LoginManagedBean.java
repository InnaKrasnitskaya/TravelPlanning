package org.travelplan.managedBean;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginManagedBean implements PhaseListener {

	private static final long serialVersionUID = 1L;
	protected final Log logger = LogFactory.getLog(getClass());

 
    /**
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String doLogin() throws ServletException, IOException {  
    	try {
	        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
	
	        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
	                .getRequestDispatcher("/j_spring_security_check");
	        
	        dispatcher.forward((ServletRequest) context.getRequest(),
	                (ServletResponse) context.getResponse());
	
	        FacesContext.getCurrentInstance().responseComplete();
	
	        return null;
    	 } 
    	catch (Exception e) {
    		return "/pages/login.xhtml?error=true";
    	 } 
    }

    public void afterPhase(PhaseEvent event) {
    }

    public void beforePhase(PhaseEvent event) {
        Exception e = (Exception) FacesContext.getCurrentInstance().
          getExternalContext().getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);
 
        if (e instanceof BadCredentialsException) {
            logger.debug("Found exception in session map: "+e);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
                    WebAttributes.AUTHENTICATION_EXCEPTION, null);
            FacesContext.getCurrentInstance().addMessage(null, 
              new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Username or password not valid.", "Username or password not valid"));
        }
    }

    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}