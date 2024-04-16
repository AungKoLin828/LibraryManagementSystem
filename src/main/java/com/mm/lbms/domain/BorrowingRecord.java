/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.domain;
import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "borrowing_record_tbl")
public class BorrowingRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equenceGenerator")
	private Long bwId;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Books book;

	@ManyToOne
	@JoinColumn(name = "patrons_id")
	private Patrons patrons;

	private LocalDate borrowDate;

	private LocalDate returnDate;

	public Long getBwId() {
		return bwId;
	}

	public void setBwId(Long bwId) {
		this.bwId = bwId;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Patrons getPatrons() {
		return patrons;
	}

	public void setPatrons(Patrons patrons) {
		this.patrons = patrons;
	}

}
