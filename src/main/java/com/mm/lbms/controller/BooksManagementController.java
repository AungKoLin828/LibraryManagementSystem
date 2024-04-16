/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mm.lbms.dto.BookDTO;
import com.mm.lbms.services.BookManagementService;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/books")
public class BookManagementController {
	
	private final BookManagementService bookManagementService;
	
	public BookManagementController(BookManagementService bookManagementService) {
		this.bookManagementService = bookManagementService;
	}
	
	@PostMapping("/add")
	public BookDTO saveBook(@RequestBody BookDTO bookDTO) {
		return bookManagementService.saveBook(bookDTO);
	}
	
	@GetMapping("/all-books")
	public List<BookDTO> bookAllLists(){
		return bookManagementService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<BookDTO> findByBookId(@PathVariable("id") Long id){
		return bookManagementService.findOne(id);
	}
	
	@PutMapping("/update")
	public Optional updateBook(@RequestBody BookDTO bookDTO) {
		return bookManagementService.partialUpdate(bookDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		bookManagementService.deleteBook(id);
	}

}
