package com.mm.lbms.domain;

/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.mm.lbms.repository.PatronsRepo;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "borrowing_record_tbl")
public class BorrowingRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equenceGenerator")
	private Long Id;

	@ManyToOne
	private Book book;

	@ManyToOne
	private PatronsRepo patrons;

	@NotNull
	private LocalDate borrowDate;

	@NotNull
	private LocalDate returnDate;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public PatronsRepo getPatrons() {
		return patrons;
	}

	public void setPatrons(PatronsRepo patrons) {
		this.patrons = patrons;
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
