package com.ahmed.fullproject.mapper;

import com.ahmed.fullproject.dto.AccountDTO;
import com.ahmed.fullproject.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface AccountMapper extends GenericMapper<Account, AccountDTO> {
    @Override
        //@Mapping(target = "id", ignore = false)
    Account asEntity(AccountDTO dto);
}