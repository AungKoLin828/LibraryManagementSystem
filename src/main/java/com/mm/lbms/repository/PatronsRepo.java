package com.mm.lbms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Patrons extends JpaRepository<Patrons, Long> {

}
