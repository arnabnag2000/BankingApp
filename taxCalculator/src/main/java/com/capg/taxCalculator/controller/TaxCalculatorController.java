package com.capg.taxCalculator.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import com.capg.taxCalculator.entity.TaxCalculator;
import com.capg.taxCalculator.service.TaxCalculatorService;
import com.itextpdf.text.DocumentException;

import VO.Profile;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "TaxCalculator")
public class TaxCalculatorController {
	
	@Autowired 
	TaxCalculatorService taxcalculatorservice;
	
	
	//will search for user tax calcuation datbase and replace it if email exists else create new //
	@PostMapping("CalculateTax")
	public ResponseEntity<?> CalculateTax(@RequestHeader("Authorization") String authorization,@RequestBody TaxCalculator tc) throws FileNotFoundException, DocumentException
	{
		try {
		Profile p = taxcalculatorservice.getProfile(authorization);
		
		if(p!=null)
		{
			tc.setEmail(p.getEmail());
			TaxCalculator t= taxcalculatorservice.calculateTax(tc);
			return new ResponseEntity<TaxCalculator>(t, HttpStatus.OK);
		}
		else
		return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			return new ResponseEntity<String>("Error Ocurred", HttpStatus.OK);
			
		}
	}
	
	@GetMapping("GetTaxDetails")
	public ResponseEntity<?> getTax(@RequestHeader("Authorization") String authorization)
	{
		try {
		Profile p = taxcalculatorservice.getProfile(authorization);
		
		if(p!=null)
		{
			
			TaxCalculator t= taxcalculatorservice.getTax(p.getEmail()).get(0);
			return new ResponseEntity<TaxCalculator>(t, HttpStatus.OK);
		}
		else
		return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			return new ResponseEntity<String>("Error Ocurred", HttpStatus.OK);
			
		}
	}
	
}
