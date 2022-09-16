/**
 * 
 */
package com.meli.challenge.security.entity;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @author german
 *
 */
public class UserDTOTranslator {
	
	 public static UserDTO userToPrincipal(User user) {
		 UserDTO userp = new UserDTO();
         List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
             .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList());

         userp.setUsername(user.getUsername());
         userp.setPassword(user.getPassword());
         userp.setEnabled(user.isEnabled());
         userp.setAuthorities(authorities);
         return userp;
     }
}
