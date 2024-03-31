package com.example.CompanyService.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.CompanyService.entity.Plane;

@Service
@FeignClient(name = "PlaneService")
public interface PlaneCommunicationService {
	@PostMapping("/plane/save")
	public Plane savePlane(@RequestBody Plane plane);
	@GetMapping("/plane/getAll")
	public List<Plane> getAll() ;
	@GetMapping("/plane/getById/{id}")
	public Plane getBydId(@PathVariable int id);
	@GetMapping("/plane/getByCompanyNo/{id}")
	public List<Plane> getByCompanyId(@PathVariable int id);
}
