package com.teamo.ejournal.core.login;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamo.ejournal.orm.Role;
import com.teamo.ejournal.orm.UserEntity;

@Service("assembler")
public class Assembler {

	private static final Logger logger = LoggerFactory.getLogger(Assembler.class);
	
	@Transactional(readOnly=true)
	User buildUserFromUserEntity(UserEntity userEntity) {
		logger.info("begin...");
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = enabled;
        boolean credentialsNonExpired = enabled;
        boolean accountNonLocked = enabled;

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : userEntity.getRoleCollection()) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        User user = new User(username,password,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
        logger.info("end... user: "+user);
        return user;
    }
	
	@Transactional(readOnly=true)
	AuthenticatedUser buildSpecialUserFromUserEntity(UserEntity userEntity) {
		logger.info("begin...");
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = enabled;
        boolean credentialsNonExpired = enabled;
        boolean accountNonLocked = enabled;

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Role role : userEntity.getRoleCollection()) {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        AuthenticatedUser user = 
        		new AuthenticatedUser(username,password,enabled,
        				accountNonExpired,credentialsNonExpired,accountNonLocked,authorities,
        				userEntity.getUsername(),userEntity.getId());
        logger.info("end... user: "+user);
        return user;
    }
}
