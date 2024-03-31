package com.example.PlaneService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PlaneService.entity.Plane;
import com.example.PlaneService.repo.PlaneRepo;

@RestController
@RequestMapping("/plane")
public class PlaneController {
	@Autowired
	private PlaneRepo repo;
	
	@PostMapping("/save")
	public Plane savePlane(@RequestBody Plane plane) {
		return repo.save(plane); 
	}
	@GetMapping("/getAll")
	public List<Plane> getAll() {
		return repo.findAll();
	}
	@GetMapping("/getById/{id}")
	public Plane getBydId(@PathVariable int id) {
		Optional<Plane> optional = repo.findById(id);
		if(optional.isPresent()) return optional.get();
		return null;
	}
	@GetMapping("/getByCompanyNo/{id}")
	public List<Plane> getByCompanyId(@PathVariable int id) {
		return repo.getByCompanyNo(id);
	}
	
}
