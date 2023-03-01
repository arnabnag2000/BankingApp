package com.capg.itrFiling;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.itrFiling.entity.ItrFiling;
import com.capg.itrFiling.repositories.ItrFilingRepository;
import com.capg.itrFiling.service.ItrFilingService;





	@SpringBootTest(classes = {ItrFilingApplicationTests.class})
	class ItrFilingApplicationTests {

		@Mock
		ItrFilingRepository irepo;
		
		@InjectMocks
		ItrFilingService iservice;
		
		@Test
		public void FileItr() {	
			
			
			ItrFiling i = new ItrFiling() ;
			i.setEmail("arnabnag2000@gmail.com");
			when(irepo.save(i)).thenReturn(i);
			System.out.println(i);
			assertEquals("arnabnag2000@gmail.com",i.getEmail());
		}
		
		@Test
		public void GetYourItr() {	
			
			List<ItrFiling> i = new ArrayList<ItrFiling>();
			i.add(new ItrFiling());
			when(irepo.findAll()).thenReturn(i);
			assertEquals(1,((List<ItrFiling>) irepo.findAll()).size());
		}
		
		

	}
