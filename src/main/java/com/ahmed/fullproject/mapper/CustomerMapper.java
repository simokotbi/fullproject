package com.ahmed.fullproject.mapper;

import org.mapstruct.Mapper;

import com.ahmed.fullproject.dto.CustomerDTO;
import com.ahmed.fullproject.entity.Customer;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface CustomerMapper extends GenericMapper<Customer, CustomerDTO> {
    @Override
    Customer asEntity(CustomerDTO dto);
}