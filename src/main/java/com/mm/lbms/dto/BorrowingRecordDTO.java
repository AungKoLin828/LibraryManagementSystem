/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.dto;
import java.io.Serializable;
import java.time.LocalDate;

import com.mm.lbms.domain.Books;
import com.mm.lbms.domain.Patrons;

public class BorrowingRecordDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long bwId;
	
	private Patrons patron;
	
	private Books books;
	
	private LocalDate borrowDate;

	private LocalDate returnDate; 

	public Long getBwId() {
		return bwId;
	}

	public void setBwId(Long bwId) {
		this.bwId = bwId;
	}

	public Patrons getPatron() {
		return patron;
	}

	public void setPatron(Patrons patron) {
		this.patron = patron;
	}

	public Books getBooks() {
		return books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LocalDate getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

}
