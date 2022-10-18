package com.ahmed.fullproject.mapper;

import com.ahmed.fullproject.dto.ProductDTO;
import com.ahmed.fullproject.entity.Product;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface ProductMapper extends GenericMapper<Product, ProductDTO> {
    @Override
    @Mapping(target = "id", ignore = false)
    Product asEntity(ProductDTO dto);
}