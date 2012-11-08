package org.travelplan.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("assembler")
public class Assembler {

  @Transactional(readOnly = true)
  public User buildUserFromUserEntity(org.travelplan.entity.User user) {

    String name = user.getName();
    String password = user.getPassword();
    boolean enabled = true; //user.isActive()
    boolean accountNonExpired = true; //user.isActive()
    boolean credentialsNonExpired = true; //user.isActive()
    boolean accountNonLocked = true; //user.isActive()

    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//    for (SecurityRoleEntity role : user.getRoles()) {
      //authorities.add(new GrantedAuthorityImpl(role.getRoleName()));
    authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
    

    User userDetails = new User(name, password, enabled,
      accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
  
    return userDetails;    
    //http://stackoverflow.com/questions/2683308/spring-security-3-database-authentication-with-hibernate
    //http://stackoverflow.com/questions/5105776/spring-security-with-custom-user-details
  }
}