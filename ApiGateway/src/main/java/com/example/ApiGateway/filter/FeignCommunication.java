package com.example.ApiGateway.filter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SECURITYSERVER")
public interface FeignCommunication {
	@GetMapping("/auth/validate")
	public String validate(@RequestParam String token);
}
