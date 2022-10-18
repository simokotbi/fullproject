package com.ahmed.fullproject.controller;

import com.ahmed.fullproject.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@Api(tags = "Customer API")
public interface CustomerController {
    //@ApiOperation("Add new data")
    public CustomerDTO save(@RequestBody CustomerDTO customer);

    //@ApiOperation("Find by Id")
    public CustomerDTO findById(@PathVariable("id") Integer id);

    //@ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Integer id);

    //@ApiOperation("Find all data")
    public List<CustomerDTO> list();

    //@ApiOperation("Pagination request")
    public Page<CustomerDTO> pageQuery(Pageable pageable);

    //@ApiOperation("Update one data")
    public CustomerDTO update(@RequestBody CustomerDTO dto, @PathVariable("id") Integer id);
}