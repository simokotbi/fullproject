package com.ahmed.fullproject.mapper;

import org.mapstruct.Mapper;

import com.ahmed.fullproject.dto.ItemDTO;
import com.ahmed.fullproject.entity.Item;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface ItemMapper extends GenericMapper<Item, ItemDTO> {
    @Override
    Item asEntity(ItemDTO dto);
}