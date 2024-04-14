package com.mm.lbms.mapper;

import org.mapstruct.Mapper;

import com.mm.lbms.domain.Book;
import com.mm.lbms.dto.BookDTO;

@Mapper(componentModel = "spring", uses = {})
public interface BookMapper extends EntityMapper<BookDTO, Book>{

}
