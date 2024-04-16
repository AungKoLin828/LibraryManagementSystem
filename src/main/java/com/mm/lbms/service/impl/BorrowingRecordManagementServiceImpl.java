package com.mm.lbms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mm.lbms.services.BorrowingRecordManagementService;

@Service
@Transactional
public class BorrowingRecordManagementServiceImpl implements BorrowingRecordManagementService {
	
	private final Logger log = LoggerFactory.getLogger(BorrowingRecordManagementServiceImpl.class);
	
	@Override
	public void borrowingBook(Long bookId, Long patronsId) {
		// TODO Auto-generated method stub
		
	}

	
}
