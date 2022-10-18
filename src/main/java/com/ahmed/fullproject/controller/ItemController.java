package com.ahmed.fullproject.controller;

import com.ahmed.fullproject.dto.ItemDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@Api(tags = "Item API")
public interface ItemController {
    //@ApiOperation("Add new data")
    public ItemDTO save(@RequestBody ItemDTO item);

    //@ApiOperation("Find by Id")
    public ItemDTO findById(@PathVariable("id") Integer id);

    //@ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Integer id);

    //@ApiOperation("Find all data")
    public List<ItemDTO> list();

    //@ApiOperation("Pagination request")
    public Page<ItemDTO> pageQuery(Pageable pageable);

    //@ApiOperation("Update one data")
    public ItemDTO update(@RequestBody ItemDTO dto, @PathVariable("id") Integer id);
}