/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.service.impl;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.mm.lbms.domain.Book;
import com.mm.lbms.dto.BookDTO;
import com.mm.lbms.mapper.BookMapper;
import com.mm.lbms.repository.BookRepo;
import com.mm.lbms.services.BookManagementService;

@Service
public class BookManagementServiceImpl implements BookManagementService{
	
	private final BookMapper bookMapper;
	
	private final BookRepo bookRepo;
	
	public BookManagementServiceImpl(BookMapper bookMapper,BookRepo bookRepo) {
		this.bookMapper = bookMapper;
		this.bookRepo = bookRepo;
	}
	
	@Override
	public BookDTO saveBook(BookDTO bookDto) {
		// TODO Auto-generated method stub
		// Mapping DTO to entity
		Book book =  bookMapper.toEntity(bookDto);
		// Saving entity
		book = bookRepo.save(book);
		// Mapping saved entity back to DTO
		return bookMapper.toDto(book);
	}

	@Override
	public List<BookDTO> findAll() {
		// TODO Auto-generated method stub	
		// Returning list of all books
		  return bookRepo.findAll().stream().map(bookMapper::toDto)
		  .collect(Collectors.toCollection(LinkedList::new));
		 
	}

	@Override
	public Optional<BookDTO> findOne(Long id) {
		// TODO Auto-generated method stub
		// Returning book by id if found
		return bookRepo.findById(id).map(bookMapper::toDto);
	}

	@Override
	public Optional<BookDTO> partialUpdate(BookDTO bookDto) {
		// TODO Auto-generated method stub
		// Partial update of book by id
		return bookRepo.findById(bookDto.getId())
				.map(exctBook -> {
					// Mapping DTO properties to existing entity
					bookMapper.partialUpdate(exctBook, bookDto);
					return exctBook;
				}
			)
			// Saving updated entity
			.map(bookRepo::save)
			.map(bookMapper::toDto);
	}

	@Override
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookRepo.deleteById(id);
	}

}
