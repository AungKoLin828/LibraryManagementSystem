/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.services.impl;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mm.lbms.domain.Books;
import com.mm.lbms.dto.BooksDTO;
import com.mm.lbms.mapper.BooksMapper;
import com.mm.lbms.repository.BooksRepository;
import com.mm.lbms.services.BooksManagementService;

@Service
public class BookManagementServiceImpl implements BooksManagementService{
	
	private final Logger log = LoggerFactory.getLogger(BookManagementServiceImpl.class);
	
	private final BooksMapper bookMapper;
	
	private final BooksRepository bookRepo;
	
	public BookManagementServiceImpl(BooksMapper bookMapper,BooksRepository bookRepo) {
		this.bookMapper = bookMapper;
		this.bookRepo = bookRepo;
	}
	
	@Override
	public BooksDTO saveBook(BooksDTO bookDto) {
		// TODO Auto-generated method stub
		log.info("Request to save the New Books : {}", bookDto);
		try {
			// Mapping DTO to entity
			Books book =  bookMapper.toEntity(bookDto);
			// Saving entity
			book.setBorrowed(false);
			book = bookRepo.save(book);
			// Mapping saved entity back to DTO
			return bookMapper.toDto(book);
		}catch(DataAccessException e) {
			String errorMessage = "DataAccessException => " + e.getMessage();
			throw new ServiceException(errorMessage);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<BooksDTO> findAll() {
		// TODO Auto-generated method stub	
		log.info("Request to find the all Books");
		// Returning list of all books
		  return bookRepo.findAll().stream().map(bookMapper::toDto)
		  .collect(Collectors.toCollection(LinkedList::new));
		 
	}

	@Override
	public Optional<BooksDTO> findOne(Long id) {
		// TODO Auto-generated method stub
		log.info("Request to find the Books by id : {}", id);
		// Returning book by id if found
		return bookRepo.findById(id).map(bookMapper::toDto);
	}

	@Override
	public Optional<BooksDTO> partialUpdate(BooksDTO bookDto) {
		// TODO Auto-generated method stub
		log.info("Request to update the Books by id : {}", bookDto);
		// Partial update of book by id
		return bookRepo.findById(bookDto.getId())
				.map(exctBook -> {
					// Mapping DTO properties to existing entity					
					if(bookDto.getAuthor() != null) {
						exctBook.setAuthor(bookDto.getAuthor());
					}
					
					if(bookDto.getIsbn() != null) {
						exctBook.setIsbn(bookDto.getIsbn());
					}
					
					if(bookDto.getTitle() != null) {
						exctBook.setTitle(bookDto.getTitle());
					}
					
					if(bookDto.getPublicationYear() != null) {
						exctBook.setPublicationYear(bookDto.getPublicationYear());
					}
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
		log.info("Request to delete the Books : {}", id);
		bookRepo.deleteById(id);
	}

}
