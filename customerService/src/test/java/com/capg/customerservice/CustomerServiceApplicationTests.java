package com.capg.customerservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.customerservice.entity.CustomerSupport;
import com.capg.customerservice.repositories.CustomerSupportRepository;
import com.capg.customerservice.service.CustomerSupportService;





	@SpringBootTest(classes = {CustomerServiceApplicationTests.class})
	class CustomerServiceApplicationTests {

		@Mock
		CustomerSupportRepository crepo;
		
		@InjectMocks
		CustomerSupportService cservice;
		
		@Test
		public void PostQuery() {	
			
			
			CustomerSupport c = new CustomerSupport((long) 1,"balaji56@gmail.com","arnabnag2000@gmail.com","unsolved","9007456789","query",new Date()) ;
			
			when(crepo.save(c)).thenReturn(c);
			System.out.println(c);
			assertEquals("arnabnag2000@gmail.com",c.getSupportEmail());
		}
		
		@Test
		public void GetTask() {	
			
			List<CustomerSupport> i = new ArrayList<CustomerSupport>();
			i.add(new CustomerSupport((long) 1,"balaji56@gmail.com","arnabnag2000@gmail.com","unsolved","9007456789","query",new Date()));
			when(crepo.findAll()).thenReturn(i);
			assertEquals(1,((List<CustomerSupport>) crepo.findAll()).size());
		}
		
		

	}
