package com.bankapp.bankapp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.bankapp.models.User;
import com.bankapp.bankapp.repositaries.UserRepo;
import com.bankapp.bankapp.repositaries.UserRepoEmail;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private UserRepoEmail urepo;
	
	public void createUser(User user) {
		userrepo.save(user);
	}
	
	public List<User> getAllUsers(){
		return userrepo.findAll();
	}
	
	public User findUserbyID(int id) {
		return userrepo.findById(id).get();
	}
	
	public String deleteByID(int id) {
		userrepo.deleteById(id);
		return "Success";
	}
	
	public Optional<User> findUserByEmail(String email) {
		System.out.println(email);
//		System.out.println("called to optional find by email");
//	urepo.findByUserEmail(email));
//		return urepo.findByUserEmail(email);
		Optional<User> u =urepo.findByUserEmail(email);
//		System.out.println(u);
		return u;
	}
}
