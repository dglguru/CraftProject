package com.intuit.craftproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intuit.craftproject.model.Driver;

@Repository
public interface IDriverRepository extends JpaRepository<Driver, Long> {
	
	Driver findByEmail(String email);

}
