package com.ahmed.fullproject.controller;

import com.ahmed.fullproject.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Order API")
public interface OrderController {
    @ApiOperation("Add new data")
    public OrderDTO save(@RequestBody OrderDTO order);

    @ApiOperation("Find by Id")
    public OrderDTO findById(@PathVariable("id") Integer id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Integer id);

    @ApiOperation("Find all data")
    public List<OrderDTO> list();

    @ApiOperation("Pagination request")
    public Page<OrderDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public OrderDTO update(@RequestBody OrderDTO dto, @PathVariable("id") Integer id);
}