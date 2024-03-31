package com.example.ApiGateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.common.net.HttpHeaders;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>{
	@Autowired
	private RouteValidator routeValidator;
	@Autowired
	private RestTemplate template;
//	@Autowired
//	private FeignCommunication feignCommunication;
	@Autowired
	private JwtUtil jwtUtil;
	
	public AuthenticationFilter() {
		super(Config.class);
		// TODO Auto-generated constructor stub
	}



	public static class Config{
		
	}

	@Override
	public GatewayFilter apply(Config config) {
		// TODO Auto-generated method stub
		return ((exchange,chain)->{
			if(routeValidator.isSecured.test(exchange.getRequest())) {
				//header contains token or not 
				if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("missing authorization header");
				}
				String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if(authHeader!=null && authHeader.startsWith("Bearer ")) {
					authHeader  = authHeader.substring(7);
				}
				try {
					//Call to authentication service
//					template.getForObject("http://SECURITYSERVER/validate?token"+authHeader, String.class);
//					feignCommunication.validate("?token="+authHeader);
					jwtUtil.validateToken(authHeader);
				}catch(Exception e) {
					throw new RuntimeException("Token is not valid");
				}
			}
			return chain.filter(exchange);
		});
	}

}
