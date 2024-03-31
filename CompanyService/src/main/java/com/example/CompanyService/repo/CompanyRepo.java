package com.example.CompanyService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CompanyService.entity.Company;
@Repository
public interface CompanyRepo extends JpaRepository<Company, Integer> {

}
