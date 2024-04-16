/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.lbms.dto.BorrowingRecordDTO;
import com.mm.lbms.exception.InvalidRequestException;
import com.mm.lbms.services.BorrowingRecordManagementService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BorrowingRecordManagementController {
	
	private final Logger log = LoggerFactory.getLogger(BorrowingRecordManagementController.class);
	
	private final BorrowingRecordManagementService borrowingRecordManagementService;
	
	public BorrowingRecordManagementController(BorrowingRecordManagementService borrowingRecordManagementService) {
		this.borrowingRecordManagementService = borrowingRecordManagementService;
	}
	
	@PostMapping("/borrow/{bookId}/patron/{patronId}")
	public ResponseEntity<?> saveBorrowedRecords(@PathVariable Long bookId, @PathVariable Long patronId) {
		log.info("Request to save the New borrow records with book Id: {}", bookId);
		log.info("Request to save the New borrow records with prtrons Id: {}", patronId);
		BorrowingRecordDTO borrowBook = borrowingRecordManagementService.borrowingBook(bookId, patronId);
		if(borrowBook != null) {
			return ResponseEntity.ok(borrowBook);
		}else {
			String errorMessage = "Not available to borrow the book";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
		
	}
	
	@PutMapping("/return/{bookId}/patron/{patronId}")
	public ResponseEntity<?> updateBorrowedRecords(@PathVariable Long bookId, @PathVariable Long patronId) {
		
		log.info("Request to update the borrow records with book Id: {}", bookId);
		log.info("Request to update the borrow records with prtrons Id: {}", patronId);
		
		if(bookId == null || patronId == null || bookId <= 0 || patronId <= 0) {
			throw new InvalidRequestException("Invalid bookId or patronId provided.");
		}
		
		BorrowingRecordDTO borrowBook = borrowingRecordManagementService.returnBook(bookId, patronId);
		
		if(borrowBook != null) {
			return ResponseEntity.ok(borrowBook);
		}else {
			String errorMessage = "Not available services";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
		
	}

}
