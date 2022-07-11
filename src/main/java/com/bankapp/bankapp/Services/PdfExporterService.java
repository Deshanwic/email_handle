package com.bankapp.bankapp.Services;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.bankapp.bankapp.models.Account;
import com.bankapp.bankapp.models.Transaction;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfExporterService {
	private AccountService AccServ;
	private Account account;

	public PdfExporterService(AccountService accServ, Account account) {
		super();
		AccServ = accServ;
		this.account = account;
	}
	


	public PdfExporterService() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void createPdf(HttpServletResponse response,int id) throws DocumentException, IOException {
		Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
        account = AccServ.findAccountbyID(id);
//		create document
		Document document = new Document(PageSize.A4);
//		pdf writer 
		PdfWriter.getInstance(document, response.getOutputStream());
//		doc open
		document.open();
//		heading
		document.add(new Phrase("ABC Bank"));
		document.add(new Paragraph("Account Number : "+ id));
		document.add(new Paragraph("Owner : "+ account.getOwner().getuFName()+" "+account.getOwner().getuLName()));
		document.add(new Paragraph("Address : "+ account.getOwner().getAddress()));
		document.add(new Paragraph("Email : "+ account.getOwner().getUserEmail()));
//		PdfDate date = new PdfDate();
		document.add(new Paragraph("Genarated Time : "+formattedDate));
//		table init
		PdfPTable table = new PdfPTable(5);
		table.setSpacingBefore(20);
//		table width setup
		table.setWidthPercentage(90);
//		table cell init
		PdfPCell cell = new PdfPCell();
//		Assigning data to cell
		cell.setPhrase(new Phrase("Transaction ID"));
	    table.addCell(cell);
//	    cell.setPhrase(new Phrase("Account Number"));
//	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Tranfered Amount"));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Date & Time"));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Tranfer Type"));
	    table.addCell(cell);
	    cell.setPhrase(new Phrase("Destination ID"));
	    table.addCell(cell);
	    
	    
	    

//	adding transaction data to table    
	    for(Transaction transaction : account.getTransactins()) {
	    	table.addCell(Integer.toString(transaction.gettID()));
//	    	table.addCell(Integer.toString(transaction.getAmount()));
	    	table.addCell(Float.toString(transaction.getAmount()));
	    	table.addCell(transaction.getDate_Time().toString());
	    	table.addCell(transaction.getType());
	    	table.addCell(Integer.toString(transaction.getDestinationAccID()));
	    }
//	    adding table to doc
	    document.add(table);
	    
//	    document.add(da)
//	    doc closing 
		document.close();
	}
	
}
