package com.capg.customerservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.customerservice.entity.CustomerSupport;





@Repository
public interface CustomerSupportRepository extends JpaRepository<CustomerSupport, Long> {

	

	
}
