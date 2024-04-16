/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.services;

import java.util.List;
import java.util.Optional;

import com.mm.lbms.dto.BookDTO;

public interface BookManagementService {
	
	BookDTO saveBook(BookDTO bookDto);
	
	List<BookDTO> findAll();
	
	Optional<BookDTO> findOne(Long id);
	
	Optional<BookDTO> partialUpdate(BookDTO bookDto);
	
	void deleteBook(Long id);

}
