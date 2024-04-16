/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-16
**************************/
package com.mm.lbms.services;

import com.mm.lbms.dto.BorrowingRecordDTO;

public interface BorrowingRecordManagementService {
	
	public BorrowingRecordDTO borrowingBook(Long bookId,Long patronsId);
	
	public BorrowingRecordDTO returnBook(Long bookId,Long patronsId);
	
	public BorrowingRecordDTO saveRecord(BorrowingRecordDTO borrowingRecordDTO);

}
