package com.ahmed.fullproject.controller;

import com.ahmed.fullproject.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Product API")
public interface ProductController {
    @ApiOperation("Add new data")
    public ProductDTO save(@RequestBody ProductDTO product);

    @ApiOperation("Find by Id")
    public ProductDTO findById(@PathVariable("id") Integer id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Integer id);

    @ApiOperation("Find all data")
    public List<ProductDTO> list();

    @ApiOperation("Pagination request")
    public Page<ProductDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public ProductDTO update(@RequestBody ProductDTO dto, @PathVariable("id") Integer id);
}