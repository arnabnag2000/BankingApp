package com.capg.itrFiling.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.capg.itrFiling.entity.ItrFiling;
import com.capg.itrFiling.service.ItrFilingService;

import VO.Profile;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;





@RestController
@SecurityRequirement(name = "ITRFiling")
public class ItrFilingController {
	
	@Autowired 
	ItrFilingService itService;
	
	
	@PostMapping("FileItr")
	public ResponseEntity<?> FileItr(@RequestHeader("Authorization") String authorization,@RequestBody ItrFiling it) 
	{
		try {
		Profile p = itService.getProfile(authorization);
		
		if(p!=null)
		{
			it.setEmail(p.getEmail());
			ItrFiling i=itService.fileItr(it);
			return new ResponseEntity<ItrFiling>(i, HttpStatus.OK);
		}
		else
		return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			return new ResponseEntity<String>("Error Occured",HttpStatus.FORBIDDEN);
			
		}
			
	}
	
	@GetMapping("GetYourItr")
	public ResponseEntity<?> GetItr(@RequestHeader("Authorization") String authorization) 
	{
		try {
		Profile p = itService.getProfile(authorization);
		
		if(p!=null)
		{
			List<ItrFiling> i=itService.getItr(p.getEmail());
			
			return new ResponseEntity<List<ItrFiling>>(i, HttpStatus.OK);
		}
		else
		return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			return new ResponseEntity<String>("Error Occured",HttpStatus.FORBIDDEN);
			
		}
	}
	
}