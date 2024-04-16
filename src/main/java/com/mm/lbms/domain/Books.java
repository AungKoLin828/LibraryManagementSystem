/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.domain;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "book_tbl")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Books implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equenceGenerator")
	@Column(name ="book_id")
	private Long bookId;

	private String title;

	private String author;

	private LocalDate publicationYear;

	private String isbn;
	
	@OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
	private List<BorrowingRecord> borrowingRecord;
	
	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(LocalDate publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<BorrowingRecord> getBorrowingRecord() {
		return borrowingRecord;
	}

	public void setBorrowingRecord(List<BorrowingRecord> borrowingRecord) {
		this.borrowingRecord = borrowingRecord;
	}

}
