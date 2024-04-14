package com.mm.lbms.repository;
/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mm.lbms.domain.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

}
