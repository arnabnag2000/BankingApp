package com.capg.profile.controller;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.profile.entity.JwtRequest;
import com.capg.profile.entity.JwtResponse;
import com.capg.profile.entity.Profile;
import com.capg.profile.jwt.utility.JwtUtility;
import com.capg.profile.profileservice.ProfileService;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "TaxProfile")
public class ProfileController {
	
	@Autowired
	ProfileService profileservice;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("Signup")
	public ResponseEntity<Profile> AddProfile(@RequestBody Profile pf)
	{
		try {
		boolean b=profileservice.checkProfileExist(pf.getEmail());
		
		if(b==false) {
		Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.YEAR, 1);
        Date oneYearFromToday = cal.getTime();
		pf.setStartDate(today);
		pf.setEndDate(oneYearFromToday);
		
		pf.setPassword(bCryptPasswordEncoder.encode(pf.getPassword()));
		//pf.setPanNumber(bCryptPasswordEncoder.encode(pf.getPanNumber()));
		
		Profile p= profileservice.addProfile(pf);
		return new ResponseEntity<Profile>(p, HttpStatus.CREATED);
		}
		else
		return new ResponseEntity<Profile>(HttpStatus.FORBIDDEN);
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			return new ResponseEntity<Profile>(HttpStatus.FORBIDDEN);
			
		}
			
        
	}
	
	@PostMapping("authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest)throws Exception
	{
		try {
			//GENERATION FIRST 2 PART TOKEN
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = profileservice.loadUserByUsername(jwtRequest.getUsername());
        System.out.println("user details "+userDetails);
        //SIGNING
        final String token =
                jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
	}
	
	@GetMapping("ViewProfile")
	public ResponseEntity<Profile> viewProfile(@RequestHeader("Authorization") String authorization)
	{
		try {
		Profile p=profileservice.viewProfile(authorization);
		return new ResponseEntity<Profile>(p, HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			return new ResponseEntity<Profile>(HttpStatus.FORBIDDEN);
			
		}
		
        
	}
	@PutMapping("UpdateProfile")
	public ResponseEntity<Profile> updateProfile(@RequestHeader("Authorization") String authorization, @RequestBody Profile pf)
	{
		try {
		Profile p=profileservice.viewProfile(authorization);
		p.setContact(pf.getContact());
		p.setFullName(pf.getFullName());
		p.setPanNumber(pf.getPanNumber());
		profileservice.addProfile(p);
		return new ResponseEntity<Profile>(p, HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			return new ResponseEntity<Profile>(HttpStatus.FORBIDDEN);
			
		}
		
        
	}
	
	@DeleteMapping("DeleteProfile")
	public ResponseEntity<String> DeleteProfile(@RequestHeader("Authorization") String authorization)
	{
		try {
		Profile p=profileservice.viewProfile(authorization);
		
		profileservice.deleteProfile(p);
		return new ResponseEntity<String>("Profile Deletd Successfully", HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
			
		}
        
	}
	@GetMapping("TestEmailValidity/{id}")
	public String TestEmailValidity(@PathVariable("id")String id)
	{
		try {
		String s=profileservice.testEmailValidity(id);
		return s;
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			return "Error Ocurred";
			
		}
	}
	@PutMapping("/ResetPassword/{id}/{password}")
	public String resetPassword(@PathVariable("id")String id,@PathVariable("password")String password) {

		try {
		password=bCryptPasswordEncoder.encode(password);
		
		profileservice.resetPassword(id,password);
		return "Password updated";
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			return "Error Ocurred";
			
		}
		

	}
	@GetMapping("GetNewRegistration")
	public List<Integer> getRegistration(@RequestHeader("Authorization") String authorization) 
	{
		try {
		Profile p=profileservice.viewProfile(authorization);
		if(p!=null) {
		List<Integer> l=profileservice.getRegistartion();
		return l;
		}
		else
			return null;
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			List<Integer> l=new ArrayList<Integer>();
			return l;
			
		}
	}
	
	@PutMapping("UpgradePlan/{plan}")
	public ResponseEntity<Profile> upgradePlan(@RequestHeader("Authorization") String authorization, @PathVariable("plan")String plan )
	{
		try {
		Profile p=profileservice.viewProfile(authorization);
		p.setPlan(plan);
		profileservice.addProfile(p);
		return new ResponseEntity<Profile>(p, HttpStatus.OK);
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			return new ResponseEntity<Profile>(HttpStatus.FORBIDDEN);
			
		}
		
        
	}
	
}
