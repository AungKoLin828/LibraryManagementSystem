/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.controller;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mm.lbms.dto.BooksDTO;
import com.mm.lbms.exception.InvalidRequestException;
import com.mm.lbms.services.BooksManagementService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("*")
public class BooksManagementController {
	
	private final Logger log = LoggerFactory.getLogger(BooksManagementController.class);
	
	private final BooksManagementService bookManagementService;
	
	public BooksManagementController(BooksManagementService bookManagementService) {
		this.bookManagementService = bookManagementService;
	}
	
	@PostMapping("/add")
	public BooksDTO saveBook(@RequestBody BooksDTO bookDTO) {
		log.info("Request to save the New Books : {}", bookDTO);
		return bookManagementService.saveBook(bookDTO);
	}
	
	@GetMapping("/all-books")
	public List<BooksDTO> bookAllLists(){
		log.info("Request to find the all Books");
		return bookManagementService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<BooksDTO> findByBookId(@PathVariable("id") Long id){
		log.info("Request to find the Books by id : {}", id);
		
		if(id == null || id <= 0) {
		  throw new  InvalidRequestException("Invalid Request");
		}
		
		return bookManagementService.findOne(id);
	}
	
	@PutMapping("/update")
	public Optional updateBook(@RequestBody BooksDTO bookDTO) {
		log.info("Request to update the Books by id : {}", bookDTO);
		return bookManagementService.partialUpdate(bookDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		log.info("Request to delete the Books : {}", id);
		
		if(id == null || id <= 0) {
		  throw new  InvalidRequestException("Invalid Request");
		}
		
		bookManagementService.deleteBook(id);
	}

}
