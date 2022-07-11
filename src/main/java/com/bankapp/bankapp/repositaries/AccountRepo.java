package com.bankapp.bankapp.repositaries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.bankapp.models.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>   {

}
