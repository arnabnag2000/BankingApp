package com.capg.customerservice.controller;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.capg.customerservice.entity.CustomerSupport;
import com.capg.customerservice.service.CustomerSupportService;

import com.itextpdf.text.DocumentException;

import VO.Profile;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "CustomerSupport")
public class CustomerSupportController {
	@Autowired
	CustomerSupportService csservice;
	
	@PostMapping("PostQuery")
	public ResponseEntity<?> PostQuery(@RequestHeader("Authorization")String authorization ,@RequestBody CustomerSupport query) 
	{
		try {
		Profile p = csservice.getProfile(authorization);
		if(p!=null)
		{
			Date d=new Date();
			query.setPostDate(d);
		
		csservice.AddQuery(query);
		return new ResponseEntity<CustomerSupport>(query, HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
		catch(Exception e)
		{
			System.out.println("Error Occured");
			return new ResponseEntity<String>("Error Occured",HttpStatus.FORBIDDEN);
			
		}
	}
	
	@GetMapping("GetTasks")
	public ResponseEntity<?> GetTasks(@RequestHeader("Authorization")String authorization) 
	{
		try {
		Profile p = csservice.getProfile(authorization);
		if(p!=null)
		{
			
			List<CustomerSupport> l=csservice.getTask();
		return new ResponseEntity<List<CustomerSupport>>(l, HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
		catch(Exception e)
		{
			System.out.println("Error Occured");
			return new ResponseEntity<String>("Error Occured",HttpStatus.FORBIDDEN);
			
		}
	}
	@PutMapping("UpdateTask")
	public ResponseEntity<?> UpdateTasks(@RequestHeader("Authorization")String authorization, @RequestBody CustomerSupport t) 
	{
		try {
		Profile p = csservice.getProfile(authorization);
		if(p!=null && p.getRole().equals("customer support"))
		{
			
			CustomerSupport c=csservice.getTaskById(t.getId());
			if(c!=null)
			{
				c.setStatus("resolved");
				c.setSupportEmail(t.getSupportEmail());
				csservice.AddQuery(c);
			}
			
			return new ResponseEntity<CustomerSupport>(c, HttpStatus.OK);
			}
			else
				return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
		catch(Exception e)
		{
			System.out.println("Error Occured");
			return new ResponseEntity<String>("Error Occured",HttpStatus.FORBIDDEN);
			
		}
		
	}
	
	
	
	
	
		
}