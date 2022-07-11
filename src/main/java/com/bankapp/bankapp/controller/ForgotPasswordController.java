package com.bankapp.bankapp.controller;

import java.util.Optional;
import java.util.Random;
import java.util.random.RandomGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.bankapp.Services.EmailSender;
import com.bankapp.bankapp.Services.UserService;
import com.bankapp.bankapp.models.Account;
import com.bankapp.bankapp.models.User;
import com.bankapp.bankapp.repositaries.UserRepoEmail;

@RestController
public class ForgotPasswordController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private EmailSender emailsender;
	
	@GetMapping("/forgotPassword")
	public String forgotPassword(@RequestParam String email) {
		System.out.println("sss");
		Optional<User> user = uService.findUserByEmail(email);
		if(user.isEmpty()) {
//			System.out.println(user);
			return "Can't find the user. Please check the Email";
		}else {
//			System.out.println(user);
			System.out.println("User Found");
			String code = String.format("%04d", new Random().nextInt(10000));
			System.out.println(code);
			emailsender.sendMail(email, "subject for 1st mail", "This is the Recovery code for "+email.toString()+": "+code.toString());
			return "done" ;
		}
//		return null;
	}
	
//	@PostMapping("/rcd")
//	public String recoveryCode(@RequestBody )

}
