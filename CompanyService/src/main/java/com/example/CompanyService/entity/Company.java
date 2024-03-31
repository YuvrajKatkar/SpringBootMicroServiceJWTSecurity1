package com.example.CompanyService.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
@Entity
@Component
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Transient
	List<Plane> planes;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(int id, String name, List<Plane> planes) {
		super();
		this.id = id;
		this.name = name;
		this.planes = planes;
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
	public List<Plane> getPlanes() {
		return planes;
	}
	public void setPlanes(List<Plane> planes) {
		this.planes = planes;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", planes=" + planes + "]";
	}
	
	
}
