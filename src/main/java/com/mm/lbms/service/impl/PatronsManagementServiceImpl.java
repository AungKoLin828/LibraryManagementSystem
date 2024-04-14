/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-13
**************************/
package com.mm.lbms.service.impl;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.mm.lbms.dto.PatronsDTO;
import com.mm.lbms.services.PatronsManagementService;

@Service
public class PatronsManagementServiceImpl implements PatronsManagementService{

	@Override
	public PatronsDTO savePatrons(PatronsDTO patronsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatronsDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<PatronsDTO> findOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<PatronsDTO> partialUpdate(PatronsDTO patronsDto) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deletePatrons(Long id) {
		// TODO Auto-generated method stub
		
	}

}
