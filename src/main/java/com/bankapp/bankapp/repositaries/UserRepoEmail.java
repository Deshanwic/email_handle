package com.bankapp.bankapp.repositaries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bankapp.bankapp.models.User;

@EnableJpaRepositories
	public interface UserRepoEmail extends JpaRepository<User, String> {
		Optional<User> findByUserEmail(String Email);

	}

