package com.example.SecurityServer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SecurityServer.entity.AuthRequest;
import com.example.SecurityServer.entity.UserInfo;
import com.example.SecurityServer.repo.UserInfoRepo;

@Service
public class UserInfoService implements UserDetailsService{
	@Autowired
	private UserInfoRepo repo;
	@Autowired
	private PasswordEncoder encoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> optional = repo.findByName(username); 
		if(optional.isPresent()) {
			return optional.map(UserInfoDetails::new).get();
		}
		return null;
	}
	public String addNewUser(UserInfo userInfo) {
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		repo.save(userInfo);
		return "User added succesffully";
	}
	

}
