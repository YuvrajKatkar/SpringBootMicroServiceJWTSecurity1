package com.example.PlaneService.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PlaneService.entity.Plane;
@Repository
public interface PlaneRepo extends JpaRepository<Plane, Integer>{

	List<Plane> getByCompanyNo(int id);

}
