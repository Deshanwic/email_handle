package com.bankapp.bankapp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.bankapp.models.Transaction;
import java.sql.Timestamp;
import java.time.LocalDate;

import com.bankapp.bankapp.repositaries.TransactionRepo;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepo transRepo;
	
	public void createtransaction(Transaction transaction) {
		transRepo.save(transaction);
	}
	
	public List<Transaction> getAllTransactions(){
		return transRepo.findAll();
	}
	
	public List<Transaction> getTransactionByDate(Timestamp date_Time) {
		return transRepo.findByDateTime(date_Time).get();
	}
	
	public List<Transaction> getFilteredTransactionByDate(Timestamp startDate,Timestamp endDate) {
		return transRepo.findByDateTimeBetween(startDate, endDate);
	}
//	public List<Transaction> getAllTransactionByID(int id) {
//		transRepo.findby
//		return transRepo.findAllById(id);
//	}
}
