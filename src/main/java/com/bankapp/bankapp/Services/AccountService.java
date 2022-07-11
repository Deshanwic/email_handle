package com.bankapp.bankapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.bankapp.models.Account;
import com.bankapp.bankapp.repositaries.AccountRepo;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepo accRepo;
	
	public void createAccount(Account acc) {
		accRepo.save(acc);
	}
	
	public List<Account> getAllAccounts(){
		return accRepo.findAll();
	}
	
	public Account findAccountbyID(int id) {
		System.out.println("account Id: " + id);
//		System.out.println(accRepo.findById(id).get());
		return accRepo.findById(id).get();
	}
	
	public String deleteByID(int id) {
		accRepo.deleteById(id);
		return "Success";
	}
	
	public void incremetValue(Account acc, float newbalance) {
		acc.setBalance(newbalance);
		accRepo.save(acc);
	}
}
