/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-15
**************************/
package com.mm.lbms.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mm.lbms.domain.Books;
import com.mm.lbms.domain.BorrowingRecord;
import com.mm.lbms.domain.Patrons;
import com.mm.lbms.dto.BooksDTO;
import com.mm.lbms.dto.BorrowingRecordDTO;
import com.mm.lbms.dto.PatronsDTO;
import com.mm.lbms.exception.NotAvailableException;
import com.mm.lbms.mapper.BooksMapper;
import com.mm.lbms.mapper.BorrowingRecordMapper;
import com.mm.lbms.mapper.PatronsMapper;
import com.mm.lbms.repository.BooksRepository;
import com.mm.lbms.repository.BorrowingRecordRepository;
import com.mm.lbms.repository.PatronsRepository;
import com.mm.lbms.services.BorrowingRecordManagementService;

@Service
@Transactional
public class BorrowingRecordManagementServiceImpl implements BorrowingRecordManagementService {
	
	private final Logger log = LoggerFactory.getLogger(BorrowingRecordManagementServiceImpl.class);
	
	private final PatronsMapper patronMapper;
	
	private final PatronsRepository patronsRepo;
	
	private final BooksMapper bookMapper;
	
	private final BooksRepository bookRepo;
	
	private final BorrowingRecordMapper borrowingRecordMapper;
	
	private final BorrowingRecordRepository borrowingRecordRepository;
	
	public BorrowingRecordManagementServiceImpl(PatronsMapper patronMapper,PatronsRepository patronsRepo,
			BooksMapper bookMapper,BooksRepository bookRepo,BorrowingRecordMapper borrowingRecordMapper,
			BorrowingRecordRepository borrowingRecordRepository) {
		
		this.patronMapper = patronMapper;
		this.patronsRepo = patronsRepo;
		this.bookMapper = bookMapper;
		this.bookRepo = bookRepo;
		this.borrowingRecordMapper = borrowingRecordMapper;
		this.borrowingRecordRepository = borrowingRecordRepository;
	}
	
	@Override
	public BorrowingRecordDTO borrowingBook(Long bookId, Long patronsId) {
		// TODO Auto-generated method stub
		log.info("Request to borrow the Books : {}", bookId);
		BorrowingRecordDTO borrow = new BorrowingRecordDTO();
		BooksDTO bookDto =  bookRepo.findById(bookId).map(bookMapper::toDto).orElse(null);
		PatronsDTO patronsDto = patronsRepo.findById(bookId).map(patronMapper::toDto).orElse(null);
		//Check available books and save the records
		try {
			
			if(bookDto != null && patronsDto != null && !bookDto.isBorrowed()) {
				
				log.info("Update to the Books Table: {}", bookId);
				Patrons patrons = patronMapper.toEntity(patronsDto); 
				Books books = bookMapper.toEntity(bookDto); 
				books.setBorrowed(true);
				bookRepo.save(books);
				
				log.info("Save to the BorrowingTable : {}", bookId);
				LocalDate currentDate = LocalDate.now();
				borrow.setBooks(books);
				borrow.setPatron(patrons);
				borrow.setBorrowDate(currentDate);
				borrow =  saveRecord(borrow);
				return borrow;
			}else {
				log.info("Not Available to borrow the books");
			}
		}catch(DataAccessException e) {
			String errorMessage = "DataAccessException => " + e.getMessage();
			throw new ServiceException(errorMessage);
		}
		return null;
	}

	@Override
	public BorrowingRecordDTO returnBook(Long bookId, Long patronsId) {
		// TODO Auto-generated method stub
		log.info("Request to return the Books : {}", bookId);
		BorrowingRecordDTO borrowDTO = new BorrowingRecordDTO();
		BooksDTO bookDto =  bookRepo.findById(bookId).map(bookMapper::toDto).orElse(null);
		PatronsDTO patronsDto = patronsRepo.findById(bookId).map(patronMapper::toDto).orElse(null);
		
		try {
			
			if(bookDto != null && patronsDto != null && bookDto.isBorrowed()) {
				
				log.info("Update to the Books Table: {}", bookId);
				Books books = bookMapper.toEntity(bookDto); 
				
				Optional<BorrowingRecord> borrowRecord = borrowingRecordRepository.findByBookIdAndPatronsId(bookId,patronsId);
				
				if(borrowRecord.isPresent()) {
					log.info("Update to the Book Table : {}", borrowRecord.get().getBwId());
					books.setBorrowed(false);
					bookRepo.save(books);
					log.info("Update to the BorrowingTable : {}", bookId);
					LocalDate currentDate = LocalDate.now();
					borrowDTO.setBooks(borrowRecord.get().getBook());
					borrowDTO.setPatron(borrowRecord.get().getPatrons());
					borrowDTO.setBwId(borrowRecord.get().getBwId());
					borrowDTO.setBorrowDate(borrowRecord.get().getBorrowDate());
					borrowDTO.setReturnDate(currentDate);
					BorrowingRecord borrowRd = borrowingRecordMapper.toEntity(borrowDTO);
					
					borrowRd.setBook(borrowDTO.getBooks());
					borrowRd.setPatrons(borrowDTO.getPatron());
					borrowRd = borrowingRecordRepository.save(borrowRd);
					
					return borrowingRecordMapper.toDto(borrowRd);
				}else {
					String errorMessage = "Book and Patrons are not Found";
					throw new NotAvailableException(errorMessage, HttpStatus.NOT_FOUND);
				}
			}else {
				log.info("Not Available to return the books");
			}
			
		}catch(DataAccessException e) {
			String errorMessage = "PersistenceException => " + e.getMessage();
			throw new NotAvailableException(errorMessage, HttpStatus.NOT_FOUND);
		}
		
		return null;
	}

	@Override
	public BorrowingRecordDTO saveRecord(BorrowingRecordDTO borrowingRecordDTO) {
		// TODO Auto-generated method stubs
			log.info("Save to the BorrowingTable : {}", borrowingRecordDTO);
		try {
			BorrowingRecord borrow = new BorrowingRecord();
			borrow.setBook(borrowingRecordDTO.getBooks());
			borrow.setPatrons(borrowingRecordDTO.getPatron());
			borrow.setBorrowDate(borrowingRecordDTO.getBorrowDate());
			borrow = borrowingRecordRepository.save(borrow);
			return  borrowingRecordMapper.toDto(borrow);
		}catch(DataAccessException e) {
			String errorMessage = "DataAccessException => " + e.getMessage();
			throw new ServiceException(errorMessage);
		}
	}	
	
}
