package com.capg.customerservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.customerservice.entity.CustomerSupport;
import com.capg.customerservice.repositories.CustomerSupportRepository;


import VO.Profile;

@Service
public class CustomerSupportService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CustomerSupportRepository csrepo;
	
	@Value("${profilejwt.baseurl}")
    private String url;
	
	public Profile getProfile(String authorization) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", authorization);
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		try {
		
		Profile response = restTemplate.exchange(
		    url+"/ViewProfile", HttpMethod.GET, requestEntity, Profile.class, new ArrayList()).getBody();
		return response;
		}
		catch(Exception e)
		{ 
			return null;
		}
		
	}



	public CustomerSupport AddQuery(CustomerSupport query) {
		
		csrepo.save(query);
		return query;
		
	}



	public List<CustomerSupport> getTask() {
		List<CustomerSupport> l=csrepo.findAll();
		return l;
		
	}



	public CustomerSupport getTaskById(Long id) {
		Optional<CustomerSupport>op= csrepo.findById(id);
		if(op.isPresent())
			return op.get();
		else 
			return null;
			
	}
}
	