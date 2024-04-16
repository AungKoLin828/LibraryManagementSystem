package com.mm.lbms.mapper;

import org.mapstruct.Mapper;

import com.mm.lbms.domain.Books;
import com.mm.lbms.dto.BooksDTO;

@Mapper(componentModel = "spring", uses = {})
public interface BorrowingRecordMapper extends EntityMapper<BooksDTO, Books> {

}
