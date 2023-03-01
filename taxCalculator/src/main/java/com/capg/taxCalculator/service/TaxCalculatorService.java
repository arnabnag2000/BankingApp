package com.capg.taxCalculator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.taxCalculator.Repositories.TaxCalculatorRepository;
import com.capg.taxCalculator.entity.TaxCalculator;

import VO.Profile;

@Service
public class TaxCalculatorService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private TaxCalculatorRepository taxrepo;
	
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

	public TaxCalculator calculateTax(TaxCalculator tc) {
		
		
		double netSalary=tc.getIncomeDigital()+tc.getIncomeInterest()+tc.getIncomeOther()+tc.getIncomeRental()+tc.getIncomeSalary()+tc.getAllowences();
		netSalary=netSalary-tc.getDeduction80C()-tc.getDeduction80CCD()-tc.getDeduction80D()-tc.getDeduction80E()-tc.getDeduction80EEA()-tc.getDeduction80G()-tc.getDeduction80TTA()-tc.getInterestLoan()-tc.getInterstHomeLoan();
		double tax=0.0;
		if(tc.getAge()<=60)
		{
			if(netSalary<=700000)
			{
				tax=0.0;
			}
			else if(netSalary<=900000)
			{
				tax= (300000*0.05)+((netSalary-600000)*0.1);
			}
			else if(netSalary<=1200000)
			{
				tax= (300000*0.05)+(300000*0.1)+((netSalary-900000)*0.15);
			}
			else if(netSalary<=1500000)
			{
				tax= (300000*0.05)+(300000*0.1)+(300000*0.15)+((netSalary-1200000)*0.2);
			}
			else 
			{
				tax= (300000*0.05)+(300000*0.1)+(300000*0.15)+(300000*0.2)+((netSalary-1500000)*0.3);
			}
			
			
		}
		else if(tc.getAge()<=80)
		{
			if(netSalary<=300000)
			{
				tax=0.0;
			}
			else if(netSalary<=500000)
			{
				tax=(netSalary-300000)*0.05;
			}
			else if(netSalary<=1000000)
			{
				tax=(200000*0.05)+(netSalary-500000)*0.2;
			}
			else 
			{
				tax=(200000*0.05)+(500000*0.2)+(netSalary-1000000)*0.3;
			}
		}
		else 
		{
			if(netSalary<=500000)
			{
				tax=0.0;
			}
			else if(netSalary<=1000000)
			{
				tax=(netSalary-500000)*0.2;
			}
			else 
			{
				tax=(500000*0.2)+(netSalary-1000000)*0.3;
			}
			
		}
		tc.setNetTax(tax);
		List<TaxCalculator> l=getTax(tc.getEmail());
		
		if(l.size()>0)
		{
			tc.setId(l.get(0).getId());
		}
		
		taxrepo.save(tc);
		
		
		return tc;
	}
	public List<TaxCalculator> getTax(String email)
	{
		return(taxrepo.findByEmail(email));
	}

}
