package com.mm.lbms.mapper;

import org.mapstruct.Mapper;
import com.mm.lbms.domain.BorrowingRecord;
import com.mm.lbms.dto.BorrowingRecordDTO;

@Mapper(componentModel = "spring", uses = {})
public interface BorrowingRecordMapper extends EntityMapper<BorrowingRecordDTO, BorrowingRecord> {

}
