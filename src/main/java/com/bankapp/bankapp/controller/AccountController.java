package com.bankapp.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.bankapp.Services.AccountService;
import com.bankapp.bankapp.models.Account;

@RestController
public class AccountController {
	@Autowired
	private AccountService accServ;
	
	@PostMapping("/createaccount")
	public Account createAccount(@RequestBody Account acc) {
		System.out.println(acc.toString());
		accServ.createAccount(acc);
		return acc;
	}
	
	@PostMapping("/getallaccounts")
	public List<Account> createAccount(){
		return accServ.getAllAccounts();
	}
	
	@PostMapping("/accbyid/{id}")
	public Account findAcountByID(@PathVariable Integer id) {
		return accServ.findAccountbyID(id);
	}
	@DeleteMapping("/deleteaccbyid/{id}")
	public String deleteUserbyID(@PathVariable Integer id) {
		return accServ.deleteByID(id);
	}

}
