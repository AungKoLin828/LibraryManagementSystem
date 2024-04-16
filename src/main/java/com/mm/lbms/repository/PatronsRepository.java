/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mm.lbms.domain.Patrons;

@Repository
public interface PatronsRepository extends JpaRepository<Patrons, Long> {

}
