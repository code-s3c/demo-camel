/**
 *		                     /$$        /$$$$$$  /$$
 *		  /$$$$$$$  /$$$$$$ | $$$$$$$ |__/  \ $$ /$$
 *		 /$$_____/ |____  $$| $$__  $$  /$$$$$$/| $$
 *		|  $$$$$$   /$$$$$$$| $$  \ $$ /$$____/ | $$
 *		 \____  $$ /$$__  $$| $$  | $$| $$      | $$
 *		 /$$$$$$$/|  $$$$$$$| $$$$$$$/| $$$$$$$$| $$
 *		|_______/  \_______/|_______/ |________/|__/                         
 *                          ~ Departement - SSI
 *                           ~ @author martinsa 
 * 
 */
package com.sab2i.demo.camel.authentication;

import com.sab2i.demo.camel.entity.Role;
import com.sab2i.demo.camel.entity.User;
import com.sab2i.demo.camel.interfaces.IUserDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    IUserDao dao;
    
    @Autowired
    PasswordEncoder encoder;
    
    @Override
    public Authentication authenticate(Authentication authentication) 
            throws AuthenticationException {
        
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = dao.loadByUsername(name);
        
        System.out.println(password);
        
        if(user != null && user.getUsername().equals(name) 
                && encoder.matches(password, user.getPassword())) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            
            for(Role role : user.getRoles()) {
                grantedAuths.add(new SimpleGrantedAuthority(role.getName()));
            }
            
            Authentication auth = new UsernamePasswordAuthenticationToken(name, 
                    password, grantedAuths);
            
            return auth;
        }
        
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
