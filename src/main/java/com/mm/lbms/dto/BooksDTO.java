/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-13
**************************/
package com.mm.lbms.dto;
import java.io.Serializable;
import java.time.LocalDate;

public class BooksDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long bookId;

	private String title;

	private String author;

	private LocalDate publicationYear;

	private String isbn;

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

}
