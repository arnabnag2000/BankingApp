package com.capg.itrFiling.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.itrFiling.entity.ItrFiling;






@Repository
public interface ItrFilingRepository extends JpaRepository<ItrFiling, Long> {

	@Query(value = "SELECT * FROM itr_Filing  WHERE  email LIKE ?", nativeQuery = true)
	public List<ItrFiling> findByEmail(@Param("emailId") String email);	
	

	
}
