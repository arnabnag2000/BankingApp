package com.capg.profile.profileservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.capg.profile.entity.Profile;
import com.capg.profile.jwt.utility.JwtUtility;
import com.capg.profile.profilerepositories.ProfileRepository;



@Service
public class ProfileService implements UserDetailsService {

	@Autowired 
	ProfileRepository profilerepo;
	
	@Autowired
	private JwtUtility jwtUtility;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Profile> l=profilerepo.findByUserName(username);
		System.out.println(l);
		if(username.indexOf('@')>-1) {
		String emailId=l.get(0).getEmail();
		String password =l.get(0).getPassword();
		
		return new User(emailId,password,new ArrayList<>());}
		else
		return new User("admin","password",new ArrayList<>());
		}



	public Profile addProfile(Profile pf) {
		profilerepo.save(pf);
		return pf;
	}



	public Profile viewProfile(String authorization) {
		String t = null;
        String userName = null;

        if(null != authorization && authorization.startsWith("Bearer ")) {
            t = authorization.substring(7);
            
        }
        String userNam=jwtUtility.getUsernameFromToken(t);
        Profile p = profilerepo.findByUserName(userNam).get(0);
        return p;
	}



	



	public void deleteProfile(Profile p) {
		profilerepo.delete(p);
		
	}



	public boolean checkProfileExist(String email) {
		List<Profile> p = profilerepo.findByUserName(email);
		if(p.size()>0)
			return true;
		else
			return false;
	}
	
	public String testEmailValidity(String id) {
		List<Profile> l=(List<Profile>) profilerepo.findAll();
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).getEmail().equals(id))
				return "valid";
		}
		return "invalid";
	}
	public void resetPassword(String id, String password) {
		List<Profile> l=profilerepo.findByUserName(id);
		l.get(0).setPassword(password);
		profilerepo.save(l.get(0));
		
	}



	public List<Integer> getRegistartion() {
		List<Profile> l=profilerepo.findAll();
		int tr=0;//total registartion
		int rf=0;//registartion free
		int rs=0;//registartion silver
		int rg=0;//registration gold
		int rlm=0;//registartion last month
		int rlsm=0;//registartion last size month
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).getRole().equalsIgnoreCase("user"))
			{
				tr++;
				if(l.get(i).getPlan().equalsIgnoreCase("free"))
					rf++;
				else if(l.get(i).getPlan().equalsIgnoreCase("silver"))
					rs++;
				else if(l.get(i).getPlan().equalsIgnoreCase("gold"))
					rg++;
				
				Date d=DateUtils.addMonths(l.get(i).getStartDate(), 1);
				if(new Date().compareTo(d)<0)
					rlm++;
				
				Date d1=DateUtils.addMonths(l.get(i).getStartDate(), 6);
				if(new Date().compareTo(d1)<0)
					rlsm++;
						
				
			}
			

		}
		List<Integer> lr= new ArrayList<Integer>();
		
		lr.add(tr);
		lr.add(rf);
		lr.add(rs);
		lr.add(rg);
		lr.add(rlm);
		lr.add(rlsm);
		return lr;
	}
}

