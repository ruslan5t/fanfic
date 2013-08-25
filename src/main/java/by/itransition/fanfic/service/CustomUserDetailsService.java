package by.itransition.fanfic.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.itransition.fanfic.domain.Role;

@Service("userDetailsService") 
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) 
				throws UsernameNotFoundException {
		by.itransition.fanfic.domain.User user = userService.getUserByName(username);
		System.out.println("Yes");
		if (null == user) {
			throw new UsernameNotFoundException(username);
		}
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			authorities.add(new GrantedAuthorityImpl(role.getName()));
		}
		return new User(user.getUsername(), user.getPassword(), authorities);
	}
	
}