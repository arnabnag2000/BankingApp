package com.capg.profileJWT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.profile.entity.Profile;
import com.capg.profile.profilerepositories.ProfileRepository;
import com.capg.profile.profileservice.ProfileService;




	@SpringBootTest(classes = {ProfileJwtApplicationTests.class})
	class ProfileJwtApplicationTests {

		@Mock
		ProfileRepository prepo;
		
		@InjectMocks
		ProfileService tservice;
		
		@Test
		public void Signup() {	
			
			
			Profile p = new Profile((long) 1,"Arnab Nag","arnabnag2000@gmail.com","8777253982","Arnab@2000","user","gold","BPTPNA7857",new Date(),new Date());
			when(prepo.save(p)).thenReturn(p);
			System.out.println(p);
			assertEquals("arnabnag2000@gmail.com",p.getEmail());
		}
		
		@Test
		public void ViewProfile() {	
			
			List<Profile> pr = new ArrayList<Profile>();
			pr.add(new Profile((long) 1,"Arnab Nag","arnabnag2000@gmail.com","8777253982","Arnab@2000","user","gold","BPTPNA7857",new Date(),new Date()));
			when(prepo.findAll()).thenReturn(pr);
			assertEquals(1,((List<Profile>) prepo.findAll()).size());
		}
		
		@Test
		public void UpdateProfile() {	
			
			List<Profile> pr = new ArrayList<Profile>();
			pr.add(new Profile((long) 1,"Arnab Nag","arnabnag2000@gmail.com","8777253982","Arnab@2000","user","gold","BPTPNA7857",new Date(),new Date()));
			when(prepo.findAll()).thenReturn(pr);
			pr.get(0).setFullName("Arnab1 Nag");
			when(prepo.save(pr.get(0))).thenReturn(pr.get(0));
			assertEquals("Arnab1 Nag",pr.get(0).getFullName());
		}
		@Test
		public void DeleteProfile() {	
			
			List<Profile> pr = new ArrayList<Profile>();
			pr.add(new Profile((long) 1,"Arnab Nag","arnabnag2000@gmail.com","8777253982","Arnab@2000","user","gold","BPTPNA7857",new Date(),new Date()));
		
			prepo.delete(pr.get(0));
			assertEquals(0,((List<Profile>) prepo.findAll()).size());
		}

	}
