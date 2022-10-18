package com.ahmed.fullproject.mapper;

import com.ahmed.fullproject.dto.EmployeeDTO;
import com.ahmed.fullproject.entity.Employee;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface EmployeeMapper extends GenericMapper<Employee, EmployeeDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    Employee asEntity(EmployeeDTO dto);
}