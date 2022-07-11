package com.bankapp.bankapp.repositaries;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankapp.bankapp.models.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>  {
	
	Optional<List<Transaction>> findByDateTime(Timestamp date_Time);
	
	List<Transaction> findByDateTimeBetween(Timestamp startDate,Timestamp endDate);
}
