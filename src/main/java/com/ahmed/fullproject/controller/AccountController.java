package com.ahmed.fullproject.controller;

import com.ahmed.fullproject.dto.AccountDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Account API")
public interface AccountController {
    @ApiOperation("Add new data")
    public AccountDTO save(@RequestBody AccountDTO account);

    @ApiOperation("Find by Id")
    public AccountDTO findById(@PathVariable("id") Integer id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Integer id);

    @ApiOperation("Find all data")
    public List<AccountDTO> list();

    @ApiOperation("Pagination request")
    public Page<AccountDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public AccountDTO update(@RequestBody AccountDTO dto, @PathVariable("id") Integer id);
}