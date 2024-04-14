/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.services;
import java.util.List;
import java.util.Optional;

import com.mm.lbms.dto.PatronsDTO;

public interface PatronsManagementService {
	
	PatronsDTO savePatrons(PatronsDTO patronsDto);
	
	List<PatronsDTO> findAll();
	
	Optional<PatronsDTO> findOne(Long id);
	
	Optional<PatronsDTO> partialUpdate(PatronsDTO patronsDto);
	
	void deletePatrons(Long id);

}
