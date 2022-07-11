
/*
 * A controller class that creates a rest controller to handle all authentication related requests
 * 
 */

package com.bankapp.bankapp.controller;

import java.util.Optional;

import org.apache.catalina.filters.AddDefaultCharsetFilter.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.bankapp.models.AuthenticationRequest;
import com.bankapp.bankapp.models.AuthenticationResponse;
import com.bankapp.bankapp.models.RequestWrapper;
import com.bankapp.bankapp.models.User;
import com.bankapp.bankapp.Services.AuthUserDetailsService;
import com.bankapp.bankapp.Services.UserService;
import com.bankapp.bankapp.utils.JwtUtil;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {
	
	//instantiate authenticationManager instance from spring security 
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	//instantiate AuthUserDetails service 
	@Autowired
	private AuthUserDetailsService userDetailsService;
	
	//instantiate User service 

	@Autowired
	private UserService userService;

	//single endpoint for authentication
	@CrossOrigin
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUseremail(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUseremail());
//System.out.println(userDetails.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
//		System.out.println(jwt);
		
//		Optional<User> correspondingUser = userService.findUserByEmail(userDetails.getUsername());
		Optional<User> correspondingUser = userService.findUserByEmail(userDetails.getUsername());
		
//System.out.println(correspondingUser.toString());

		RequestWrapper body = new RequestWrapper(new AuthenticationResponse(jwt,correspondingUser), "success", "fetched");
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(body);
			
	}

}
