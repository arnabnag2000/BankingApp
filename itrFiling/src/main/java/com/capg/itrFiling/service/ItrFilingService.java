package com.capg.itrFiling.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.itrFiling.entity.ItrFiling;
import com.capg.itrFiling.repositories.ItrFilingRepository;


import VO.Profile;


@Service
public class ItrFilingService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ItrFilingRepository itrepo;
	
	 @Value("${profilejwt.baseurl}")
	    private String url;
	
	public Profile getProfile(String authorization) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", authorization);
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		System.out.println(url);
		try {
		
		Profile response = restTemplate.exchange(
		    url+"/ViewProfile", HttpMethod.GET, requestEntity, Profile.class, new ArrayList()).getBody();
		return response;
		}
		catch(Exception e)
		{ 
			System.out.println(e);
			return null;
		}
		
	}

	public ItrFiling fileItr(ItrFiling it) {
		itrepo.save(it);
		return it;
	}

	public List<ItrFiling> getItr(String email) {
		
		List<ItrFiling> l= itrepo.findByEmail(email);
		return l;
	}

}
