package org.travelplan.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.travelplan.entity.UserRole;

@Service("assembler")
public class Assembler {

  public User buildUserFromUserEntity(List<UserRole> userRoleList) {
    String name = userRoleList.get(0).getUser().getName();
    String password = userRoleList.get(0).getUser().getPassword();
    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;
    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    
    for (UserRole userRole : userRoleList)
      authorities.add(new GrantedAuthorityImpl(userRole.getRole().getName()));

    User userDetails = new User(name, password, enabled,
      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
  
    return userDetails;    
    //http://stackoverflow.com/questions/2683308/spring-security-3-database-authentication-with-hibernate
    //http://stackoverflow.com/questions/5105776/spring-security-with-custom-user-details
  }
}