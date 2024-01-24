package com.MiniRedditt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.MiniRedditt.repositories.UserRepository;
import com.MiniRedditt.security.CustomSecurityUser;
import com.MiniRedditt.domain.User;
@Service

public class UserDetailsServiceImpl implements UserDetailsService {
@Autowired
private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
User user= userRepo.findByUsername(username);
if(user==null) {
	
	throw  new UsernameNotFoundException("Invalid Username and Password!");
}
System.out.println("User loaded: " + user.getUsername());

System.out.println("User loaded: " + user.getPassword());

return new CustomSecurityUser(user);
	}

}
