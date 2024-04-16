/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.controller;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mm.lbms.dto.PatronsDTO;
import com.mm.lbms.exception.InvalidRequestException;
import com.mm.lbms.services.PatronsManagementService;

@RestController
@RequestMapping("/api/patrons")
@CrossOrigin("*")
public class PatronsManagementController {
	
	private final Logger log = LoggerFactory.getLogger(PatronsManagementController.class);
	
	private final PatronsManagementService patronsManagementService;
	
	public PatronsManagementController(PatronsManagementService patronsManagementService) {
		this.patronsManagementService = patronsManagementService;
	}
	
	@PostMapping("/add")
	public PatronsDTO savePatrons(@RequestBody PatronsDTO patronsDTO) {
		log.info("Request to save the New Patrons : {}", patronsDTO);
		return patronsManagementService.savePatrons(patronsDTO);
	}
	
	@GetMapping("/all-patrons")
	public List<PatronsDTO> patronsAllLists(){
		log.info("Request to find the all Patrons");
		return patronsManagementService.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<PatronsDTO> findByPatronsId(@PathVariable("id") Long id){
		log.info("Request to find the Patrons by Id : {}", id);
		if(id == null || id <= 0 ) {
			throw new InvalidRequestException("Invalid bookId or patronId provided.");
		}
		return patronsManagementService.findOne(id);
	}
	
	@PutMapping("/update")
	public Optional updatePatrons(@RequestBody PatronsDTO patronsDTO) {
		log.info("Request to find the Patrons by id : {}", patronsDTO);
		return patronsManagementService.partialUpdate(patronsDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deletePatrons(@PathVariable("id") Long id) {
		log.info("Request to delete the Patrons : {}", id);
		
		if(id == null || id <= 0 ) {
			throw new InvalidRequestException("Invalid bookId or patronId provided.");
		}
		
		patronsManagementService.deletePatrons(id);
	}

}
