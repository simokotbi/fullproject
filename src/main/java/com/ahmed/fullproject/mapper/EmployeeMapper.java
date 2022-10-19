package com.ahmed.fullproject.mapper;

import org.mapstruct.Mapper;

import com.ahmed.fullproject.dto.EmployeeDTO;
import com.ahmed.fullproject.entity.Employee;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface EmployeeMapper extends GenericMapper<Employee, EmployeeDTO> {
    @Override
    Employee asEntity(EmployeeDTO dto);
}