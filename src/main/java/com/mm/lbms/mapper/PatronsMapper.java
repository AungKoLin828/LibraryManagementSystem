/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-15
**************************/
package com.mm.lbms.mapper;

import org.mapstruct.Mapper;

import com.mm.lbms.domain.Patrons;
import com.mm.lbms.dto.PatronsDTO;

@Mapper(componentModel = "spring", uses = {})
public interface PatronsMapper extends EntityMapper<PatronsDTO, Patrons>{

}
