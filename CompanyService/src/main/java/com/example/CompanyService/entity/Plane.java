package com.example.CompanyService.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Plane {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int companyNo;
	public Plane() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plane(int id, String name, int companyNo) {
		super();
		this.id = id;
		this.name = name;
		this.companyNo = companyNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	@Override
	public String toString() {
		return "Plane [id=" + id + ", name=" + name + ", companyNo=" + companyNo + "]";
	}
	
	
}
