package org.travelplan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.UserDAO;
import org.travelplan.entity.User;
import org.travelplan.service.Assembler;

@Service("userDetailsService") 
public class UserDetailsServiceImpl implements UserDetailsService {
	
    @Autowired
    private UserDAO userDAO;
    
    @Autowired 
    private Assembler assembler; 
    
    
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException, DataAccessException {

    	User user = userDAO.findByName(username);
      if (user == null)
        throw new UsernameNotFoundException("user not found");

      return assembler.buildUserFromUserEntity(user);
    }       
}
