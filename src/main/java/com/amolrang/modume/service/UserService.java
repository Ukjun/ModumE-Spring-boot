package com.amolrang.modume.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.Spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amolrang.modume.model.UserModel;
import com.amolrang.modume.repository.UserDAO;

@Service
public class UserService implements UserDetailsService {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserDAO userDAO;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserModel userModel = userDAO.findById(username);
		if(userModel == null) {return userModel;};
		userModel.setAuthorities(getAuthorities(username));
		UserDetails userDetails = new UserDetails() {

			@Override
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public String getUsername() {
				// TODO Auto-generated method stub
				return userModel.getId();
			}

			@Override
			public String getPassword() {
				// TODO Auto-generated method stub
				return userModel.getPassword();
			}

			@Override
			public Collection getAuthorities() {
				// TODO Auto-generated method stub

				return userModel.getAuthorities();
			}
		};
		return userModel;
	}

	public UserModel save(UserModel userModel, String role) {
		// TODO Auto-generated method stublog.info(role);
		userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
		userModel.setAccountNonExpired(true);
		userModel.setAccountNonLocked(true);
		userModel.setCredentialsNonExpired(true);
		userModel.setEnabled(true);
		userModel.setUserName(userModel.getUsername());
		
		log.info("userModel {}",userModel);
		
		return userDAO.save(userModel, role);
	}

	public Collection<GrantedAuthority> getAuthorities(String username) {
		//System.out.println(username);
		List<String> string_authorities = userDAO.findAuthoritiesByID(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String authority : string_authorities) {
			authorities.add(new SimpleGrantedAuthority(authority));
		}
		return authorities;
	}

}

