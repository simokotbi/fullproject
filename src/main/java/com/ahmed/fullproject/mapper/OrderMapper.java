package com.ahmed.fullproject.mapper;

import org.mapstruct.Mapper;

import com.ahmed.fullproject.dto.OrderDTO;
import com.ahmed.fullproject.entity.Order;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface OrderMapper extends GenericMapper<Order, OrderDTO> {
    @Override
    Order asEntity(OrderDTO dto);
}