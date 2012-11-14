package org.travelplan;

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
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Component;

/*@ManagedBean(name="loginBean")
@RequestScoped*/

@Component
@Scope ( "request" )
public class LoginBean  {
	
	protected final Log logger = LogFactory.getLog(getClass());

    
    /**
     *
     * Redirects the login request directly to spring security check.
     * Leave this method as it is to properly support spring security.
     * 
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String doLogin() throws ServletException, IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                .getRequestDispatcher("/j_spring_security_check");

        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());

        FacesContext.getCurrentInstance().responseComplete();

        return null;
    }
}