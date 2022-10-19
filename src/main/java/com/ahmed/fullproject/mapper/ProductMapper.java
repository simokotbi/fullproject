package com.ahmed.fullproject.mapper;

import org.mapstruct.Mapper;

import com.ahmed.fullproject.dto.ProductDTO;
import com.ahmed.fullproject.entity.Product;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface ProductMapper extends GenericMapper<Product, ProductDTO> {
    @Override
    Product asEntity(ProductDTO dto);
}