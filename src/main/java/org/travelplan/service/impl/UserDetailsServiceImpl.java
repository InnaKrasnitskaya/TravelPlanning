package org.travelplan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.stereotype.Service;
import org.travelplan.constant.Constant;
import org.travelplan.dao.UserRoleDAO;
import org.travelplan.entity.UserRole;
import org.travelplan.service.Assembler;

@Service("userDetailsService") 
public class UserDetailsServiceImpl implements UserDetailsService {
	
    @Autowired
    private UserRoleDAO userRoleDAO;
    
    @Autowired 
    private Assembler assembler;     
    
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException, DataAccessException {

    	List<UserRole> userRole =  userRoleDAO.getUserRoles(username);   
    	
    	if (userRole == null)
    		throw new UsernameNotFoundException("User or user role not found");
    	else
    		//Save current user id
    		Constant.setIdCurrentUser(userRole.get(0).getUser().getIdUser());

      return assembler.buildUserFromUserEntity(userRole);
    }       
}
