package com.ahmed.fullproject.mapper;

import com.ahmed.fullproject.dto.ItemDTO;
import com.ahmed.fullproject.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface ItemMapper extends GenericMapper<Item, ItemDTO> {
    @Override
    //@Mapping(target = "id", ignore = false)
    Item asEntity(ItemDTO dto);
}