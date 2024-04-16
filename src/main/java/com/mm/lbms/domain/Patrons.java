/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.domain;
import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import jakarta.persistence.*;

@Entity
@Table(name = "partrons_tbl")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Patrons implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equenceGenerator")
	@Column(name ="patrons_id")
	private Long patronId;

	private String name;
	
	private String phoneNo;

	private String email;

	private String address;
	
	@OneToMany(mappedBy = "patrons",cascade = CascadeType.ALL)
	private List<BorrowingRecord> borrowingRecord;

	public Long getPatronId() {
		return patronId;
	}

	public void setPatronId(Long patronId) {
		this.patronId = patronId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<BorrowingRecord> getBorrowingRecord() {
		return borrowingRecord;
	}

	public void setBorrowingRecord(List<BorrowingRecord> borrowingRecord) {
		this.borrowingRecord = borrowingRecord;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
