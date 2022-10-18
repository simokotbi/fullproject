package com.ahmed.fullproject.mapper;

import com.ahmed.fullproject.dto.CustomerDTO;
import com.ahmed.fullproject.entity.Customer;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface CustomerMapper extends GenericMapper<Customer, CustomerDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    Customer asEntity(CustomerDTO dto);
}