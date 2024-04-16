/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.dto;
import java.io.Serializable;

public class PatronsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long patronId;

	private String name;

	private String phoneNo;

	private String email;

	private String address;

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

}
