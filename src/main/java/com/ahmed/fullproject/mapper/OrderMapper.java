package com.ahmed.fullproject.mapper;

import com.ahmed.fullproject.dto.OrderDTO;
import com.ahmed.fullproject.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface OrderMapper extends GenericMapper<Order, OrderDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    Order asEntity(OrderDTO dto);
}