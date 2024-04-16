/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-15
**************************/
package com.mm.lbms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mm.lbms.domain.BorrowingRecord;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord,Long>{
	
	Optional<BorrowingRecord> findByBookIdAndPatronsId(Long bookId, Long patronsId);
	
}
