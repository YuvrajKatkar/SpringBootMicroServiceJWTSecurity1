package com.example.CompanyService.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CompanyService.entity.Company;
import com.example.CompanyService.entity.Plane;
import com.example.CompanyService.repo.CompanyRepo;
import com.example.CompanyService.service.PlaneCommunicationService;
@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	private CompanyRepo repo;
	@Autowired
	private PlaneCommunicationService planeCommunicationService;
	@PostMapping("/save")
	public Company save(@RequestBody Company company) {
		return repo.save(company);
	}
	@GetMapping("/getAll")
	public List<Company> getAll(){
		List<Company> companyList = repo.findAll();
		List<Company> companyListActual  = companyList.stream().map(company->{
			List<Plane> planes = planeCommunicationService.getByCompanyId(company.getId());
			company.setPlanes(planes);
			return company;
		}).toList();
		return companyListActual;
	}
	@GetMapping("/getById/{id}")
	public Company getById(@PathVariable int id) {
		Optional<Company> optional = repo.findById(id);
		return optional.get();
	}
}
