package com.capg.taxCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.taxCalculator.Repositories.TaxCalculatorRepository;
import com.capg.taxCalculator.entity.TaxCalculator;
import com.capg.taxCalculator.service.TaxCalculatorService;

@SpringBootTest(classes = {TaxCalculatorApplicationTests.class})
class TaxCalculatorApplicationTests {

	@Mock
	TaxCalculatorRepository trepo;
	
	@InjectMocks
	TaxCalculatorService tservice;
	
	@Test
	public void CalculateTax() {	
		
		
		TaxCalculator tc = new TaxCalculator((long) 1,"arnabnag2000@gmail.com","2024",39,4000000,10000,120000,100000,200000,300000,70000,150000,500000,100000,200000,300000,40000,30000,15000,10000);
		when(trepo.save(tc)).thenReturn(tc);
		System.out.println(tc);
		assertEquals("arnabnag2000@gmail.com",tc.getEmail());
	}
	
	@Test
	public void getTax() {	
		
		List<TaxCalculator> tax = new ArrayList<TaxCalculator>();
		tax.add(new TaxCalculator((long) 1,"arnabnag2000@gmail.com","2024",39,4000000,10000,120000,100000,200000,300000,70000,150000,500000,100000,200000,300000,40000,30000,15000,10000));
		when(trepo.findAll()).thenReturn(tax);
		assertEquals(1,((List<TaxCalculator>) trepo.findAll()).size());
	}

}
