package com.capg.springEmail;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.io.File;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@SecurityRequirement(name = "TaxEmail")
public class Controller {

	@Autowired
	private EmailSenderService service;
	
	@GetMapping("SendEmail/{id}/{subject}/{body}")
	public String triggerMail(@PathVariable("id") String id,@PathVariable("subject") String subject,@PathVariable("body") String body){
		try {
		return service.sendSimpleEmail(id,body,subject,"arnabnag56@gmail.com");
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			return "Error Ocurred";
			
		}

	}
	@PostMapping("SendEmailWithAttachment/{id}/{subject}/{body}")
	public String triggerMailAttachment(@PathVariable("id") String id,@PathVariable("subject") String subject,@PathVariable("body") String body,@RequestBody File attachment) throws MessagingException{
		try {
		return service.sendEmailWithAttachment(id,body,subject,"arnabnag56@gmail.com",attachment);
		}
		catch(Exception e)
		{
			System.out.println("Error Ocurred");
			return "Error Ocurred";
			
		}
	}
}
