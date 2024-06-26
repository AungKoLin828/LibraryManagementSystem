/**************************
*Author Name   : Aung Ko Lin
*Creation Date : 2024-04-14
**************************/
package com.mm.lbms.mapper;
import org.mapstruct.Mapper;

import com.mm.lbms.domain.Books;
import com.mm.lbms.dto.BooksDTO;

@Mapper(componentModel = "spring", uses = {})
public interface BooksMapper extends EntityMapper<BooksDTO, Books>{
	
}
