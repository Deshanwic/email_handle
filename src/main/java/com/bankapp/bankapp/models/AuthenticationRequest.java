/*
 * An model for data received in the authentication request
 */


package com.bankapp.bankapp.models;
	

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {


    private String userEmail;
    private String password;

    public String getUseremail() {
        return userEmail;
    }

    public void setUserEmail(String useremail) {
        this.userEmail = useremail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //need default constructor for JSON Parsing
    public AuthenticationRequest()
    {

    }

    public AuthenticationRequest(String useremail, String password) {
        this.setUserEmail(useremail);
        this.setPassword(password);
    }
}