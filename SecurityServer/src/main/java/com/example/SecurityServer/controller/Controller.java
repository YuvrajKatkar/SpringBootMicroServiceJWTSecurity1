package com.example.SecurityServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SecurityServer.entity.AuthRequest;
import com.example.SecurityServer.entity.UserInfo;
import com.example.SecurityServer.service.JwtService;
import com.example.SecurityServer.service.UserInfoService;

@RestController
@RequestMapping("/auth")
public class Controller {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private JwtService jwtService;
	
	@GetMapping("/public")
	public String publicApi() {
		return "api for all";
	}
	@GetMapping("/admin/api")
	public String adminApi() {
		return "api for admin";
	}
	@GetMapping("/user/api")
	public String userApi() {
		return "api for user";
	}
	@PostMapping("/addNewUser")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return userInfoService.addNewUser(userInfo);
	}
	@GetMapping("/validate")
	public String validate(@RequestParam String token) {
		jwtService.validateToken(token);
		return "Token is valid";
	}
	@PostMapping("/genrate")
	public String genrateToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getName());
		}
		return "OOps something went wrong";
	}
}
