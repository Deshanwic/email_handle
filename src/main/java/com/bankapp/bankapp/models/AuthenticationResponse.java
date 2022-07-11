/*
 * A model for the data to be sent back after authentication
 */


package com.bankapp.bankapp.models;

import java.io.Serializable;
import java.util.Optional;

public class AuthenticationResponse implements Serializable {

    private String jwt;
    private Optional<User> user;

 

//    public AuthenticationResponse(String jwt2, Optional<User> correspondingUser) {
//		super();
//		// TODO Auto-generated constructor stub
//	}

//	public AuthenticationResponse(String jwt, User user) {
//		this.jwt = jwt;
//		this.user = user;
//	}
	
	


	public AuthenticationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}




	public AuthenticationResponse(String jwt, Optional<User> user) {
		super();
		this.jwt = jwt;
		this.user = user;
	}




	@Override
	public String toString() {
		return "AuthenticationResponse [jwt=" + jwt + ", user=" + user + "]";
	}


	public void setJwt(String jwt) {
		this.jwt = jwt;
	}


//	public void setUser(User user) {
//		this.user = user;
//	}
//
//
//	public User getUser() {
//		return user;
//	}


	public Optional<User> getUser() {
		return user;
	}




	public void setUser(Optional<User> user) {
		this.user = user;
	}




	public String getJwt() {
        return jwt;
    }
}
