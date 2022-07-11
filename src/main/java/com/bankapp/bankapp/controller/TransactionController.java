package com.bankapp.bankapp.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.bankapp.Services.AccountService;
import com.bankapp.bankapp.Services.PdfExporterService;
import com.bankapp.bankapp.Services.TransactionService;
import com.bankapp.bankapp.models.Account;
import com.bankapp.bankapp.models.Transaction;
import com.lowagie.text.DocumentException;

import ch.qos.logback.classic.Logger;

@RestController
@CrossOrigin(origins = "*")
public class TransactionController {
	
	@Autowired
	private TransactionService transServ;
	@Autowired
	private AccountService accServ;
	
	@PostMapping("/deposite")
	public void depositeMoney(@RequestBody Transaction transaction) {
		int Accountid = transaction.getAccNumber();
		System.out.println("full transaction record: "+transaction.toString());
//		System.out.println("id at controller: " + transaction.getAccNumber());
		float amount = transaction.getAmount();
//		System.out.println("before fetching account");
		Account depositeAccountID = accServ.findAccountbyID(Accountid);
//		System.out.println("reached this point");
		float newBalace = (accServ.findAccountbyID(Accountid).getBalance() + (float) amount);
		
		
		accServ.incremetValue(depositeAccountID, newBalace);
		transServ.createtransaction(transaction);
	}
	
	@PostMapping("/withdraw")
	public String withdrawMoney(@RequestBody Transaction transaction) {
		int Accountid = transaction.getAccNumber();
//		System.out.println(transaction.toString());
//		System.out.println("id at controller: " + transaction.getAccNumber());
		float amount = transaction.getAmount();
//		System.out.println("before fetching account");
		Account depositeAccountID = accServ.findAccountbyID(Accountid);
//		System.out.println("reached this point");
		Account acc = accServ.findAccountbyID(Accountid);
		if (acc.getBalance()<=0 || acc.getBalance()<=amount) {
			return "Sorry! You don't have engouh balace.";
		}else {
			float newBalace = (acc.getBalance() - (float) amount);
			accServ.incremetValue(depositeAccountID, newBalace);
			transServ.createtransaction(transaction);
			return "Successfully Withdraw!!!!";
		}
		
	}
	
	@PostMapping("/transaction")
	public String transaction(@RequestBody Transaction transaction) {
		
		try {
			float amount = transaction.getAmount();
			
			int Accountid = transaction.getAccNumber();
			int desAccid = transaction.getDestinationAccID();
			
			Account sourceAccount = accServ.findAccountbyID(Accountid);
			Account destinationAcc = accServ.findAccountbyID(desAccid);
			
//			if(sourceAccount.equals(null) && destinationAcc.equals(null)) {
//				return "Account is not in the system";
//			}else 
				if(sourceAccount.getBalance()<=0 || sourceAccount.getBalance()<=amount) {
				return "Sorry!!!! You don't have engouh Account balance";
			}else {
				float newSourceBalace = (sourceAccount.getBalance() - (float) amount);
				float newDestinationBalace = (destinationAcc.getBalance() + (float) amount);
				
				accServ.incremetValue(sourceAccount, newSourceBalace);
				accServ.incremetValue(destinationAcc, newDestinationBalace);
//				System.out.println(transaction.toString());
//				System.out.println("id at controller: " + transaction.getAccNumber());
//				System.out.println("before fetching account");
//				System.out.println("reached this point");
				
				transServ.createtransaction(transaction);
				return "Successfully tranfered";
			}
			
		} catch (NoSuchElementException e) {
			if(e != null) {
				return "Account is not in the system";
			}
			// TODO: handle exception
		}
//		return null;
		return null;
		
		
		
	}
	
	@GetMapping("/alltransactions")
	public List<Transaction> getAllTransactions(){
		return transServ.getAllTransactions();
		
	}
	
	@PostMapping("/transactionbyaccid/{id}")
	public List<Transaction> gteTransactionByAccId(@PathVariable Integer id){
		Account acc = accServ.findAccountbyID(id);
		List<Transaction> trans = acc.getTransactins();
		return trans;
	}
	
	@GetMapping("/exporttransaction/{id}")
	public void createPdf(HttpServletResponse response,@PathVariable Integer id) throws DocumentException, IOException {
		Account acc = accServ.findAccountbyID(id);
		response.setContentType("application/pdf");
		PdfExporterService pdfService = new PdfExporterService(accServ, acc);
		pdfService.createPdf(response,id);
	}
	@GetMapping("/filtedTransaction/{datetime}")
	public List<Transaction> getFiletedBydate(@PathVariable String datetime ){
		Timestamp DateTime = Timestamp.valueOf(datetime);
		return transServ.getTransactionByDate(DateTime);
		
	}
	
	@GetMapping("/filtedTransactionbyDate")
	public List<Transaction> getFiletedBydate(@RequestParam String startDate,@RequestParam String endDate){
		Timestamp sdate = Timestamp.valueOf(startDate);
		Timestamp edate = Timestamp.valueOf(endDate);
		return transServ.getFilteredTransactionByDate(sdate, edate);
		
	}
//	@PostMapping("/withdraw")
//	public void  createWithdraw(@RequestBody ) {
//	}
	
	
}
