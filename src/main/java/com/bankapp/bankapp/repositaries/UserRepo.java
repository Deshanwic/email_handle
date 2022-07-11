package com.bankapp.bankapp.repositaries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankapp.bankapp.models.User;

public interface UserRepo extends JpaRepository<User, Integer> {
//	Optional<User> findByUserEmail(String Email);

}


