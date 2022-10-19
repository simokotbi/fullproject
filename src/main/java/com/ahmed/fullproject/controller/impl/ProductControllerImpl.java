package com.ahmed.fullproject.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ahmed.fullproject.controller.ProductController;
import com.ahmed.fullproject.dto.ProductDTO;
import com.ahmed.fullproject.entity.Product;
import com.ahmed.fullproject.mapper.ProductMapper;
import com.ahmed.fullproject.service.ProductService;

@RequestMapping("/product")
@RestController
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductControllerImpl(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO save(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.asEntity(productDTO);
        return productMapper.asDTO(productService.save(product));
    }

    @Override
    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable("id") Integer id) {
        Product product = productService.findById(id).orElse(null);
        return productMapper.asDTO(product);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        productService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<ProductDTO> list() {
        return productMapper.asDTOList(productService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<ProductDTO> pageQuery(Pageable pageable) {
        Page<Product> productPage = productService.findAll(pageable);
        List<ProductDTO> dtoList = productPage
                .stream()
                .map(productMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, productPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public ProductDTO update(@RequestBody ProductDTO productDTO, @PathVariable("id") Integer id) {
        Product product = productMapper.asEntity(productDTO);
        return productMapper.asDTO(productService.update(product, id));
    }
}