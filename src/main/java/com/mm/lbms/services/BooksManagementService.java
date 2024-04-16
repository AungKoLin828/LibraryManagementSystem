/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.services;

import java.util.List;
import java.util.Optional;

import com.mm.lbms.dto.BooksDTO;

public interface BooksManagementService {
	
	BooksDTO saveBook(BooksDTO bookDto);
	
	List<BooksDTO> findAll();
	
	Optional<BooksDTO> findOne(Long id);
	
	Optional<BooksDTO> partialUpdate(BooksDTO bookDto);
	
	void deleteBook(Long id);

}
