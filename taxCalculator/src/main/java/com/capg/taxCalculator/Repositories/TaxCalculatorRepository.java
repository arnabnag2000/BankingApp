package com.capg.taxCalculator.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.capg.taxCalculator.entity.TaxCalculator;




@Repository
public interface TaxCalculatorRepository extends JpaRepository<TaxCalculator, Long> {

	@Query(value = "SELECT * FROM tax_calculator  WHERE  email LIKE ?", nativeQuery = true)
	public List<TaxCalculator> findByEmail(@Param("emailId") String email);	

	
}
