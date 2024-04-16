/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-13
**************************/
package com.mm.lbms.service.impl;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mm.lbms.domain.Patrons;
import com.mm.lbms.dto.PatronsDTO;
import com.mm.lbms.mapper.PatronsMapper;
import com.mm.lbms.repository.PatronsRepository;
import com.mm.lbms.services.PatronsManagementService;

@Service
public class PatronsManagementServiceImpl implements PatronsManagementService{
	
	private final Logger log = LoggerFactory.getLogger(PatronsManagementServiceImpl.class);
	
	private final PatronsMapper patronMapper;
	
	private final PatronsRepository patronsRepo;
	
	public PatronsManagementServiceImpl(PatronsMapper patronMapper,PatronsRepository patronsRepo) {
		this.patronMapper = patronMapper;
		this.patronsRepo = patronsRepo;
	}
	
	@Override
	public PatronsDTO savePatrons(PatronsDTO patronsDto) {
		// TODO Auto-generated method stub
		log.info("Request to save the New Patrons : {}", patronsDto);
		// Mapping DTO to entity
		Patrons patrons = patronMapper.toEntity(patronsDto);
		// Saving entity
		patrons = patronsRepo.save(patrons);
		// Mapping saved entity back to DTO
		return patronMapper.toDto(patrons);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PatronsDTO> findAll() {
		// TODO Auto-generated method stub
		log.info("Request to find the all Patrons");
		// Returning list of all Patrons
		return patronsRepo.findAll().stream().map(patronMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	public Optional<PatronsDTO> findOne(Long id) {
		// TODO Auto-generated method stub
		log.info("Request to find the Patrons by Id : {}", id);
		// Returning Patrons by id if found
		return patronsRepo.findById(id).map(patronMapper::toDto);
	}

	@Override
	public Optional<PatronsDTO> partialUpdate(PatronsDTO patronsDto) {
		// TODO Auto-generated method stub
		log.info("Request to find the Patrons by id : {}", patronsDto);
		// Partial update of Patrons by id
		return patronsRepo.findById(patronsDto.getId())
				.map(exctPatron -> {
					// Mapping DTO properties to existing entity
					if(patronsDto.getName() != null) {
						exctPatron.setName(patronsDto.getName());
					}
					
					if(patronsDto.getAddress() != null) {
						exctPatron.setAddress(patronsDto.getAddress());
					}
					
					if(patronsDto.getEmail() != null) {
						exctPatron.setEmail(patronsDto.getEmail());
					}
					
					if(patronsDto.getPhoneNo() != null) {
						exctPatron.setPhoneNo(patronsDto.getPhoneNo());
					}
					
					patronMapper.partialUpdate(exctPatron, patronsDto);
					return exctPatron;
				}
			)
			// Saving updated entity
			.map(patronsRepo:: save)
			.map(patronMapper:: toDto);
	}

	@Override
	public void deletePatrons(Long id) {
		// TODO Auto-generated method stub
		log.info("Request to delete the Patrons : {}", id);
		patronsRepo.deleteById(id);
	}

}
