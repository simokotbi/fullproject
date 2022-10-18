package com.ahmed.fullproject.controller.impl;

import com.ahmed.fullproject.controller.ItemController;
import com.ahmed.fullproject.dto.ItemDTO;
import com.ahmed.fullproject.entity.Item;
import com.ahmed.fullproject.mapper.ItemMapper;
import com.ahmed.fullproject.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/item")
@RestController
public class ItemControllerImpl implements ItemController {
    private final ItemService itemService;
    private final ItemMapper itemMapper;

    public ItemControllerImpl(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO save(@RequestBody ItemDTO itemDTO) {
        Item item = itemMapper.asEntity(itemDTO);
        return itemMapper.asDTO(itemService.save(item));
    }

    @Override
    @GetMapping("/{id}")
    public ItemDTO findById(@PathVariable("id") Integer id) {
        Item item = itemService.findById(id).orElse(null);
        return itemMapper.asDTO(item);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        itemService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<ItemDTO> list() {
        return itemMapper.asDTOList(itemService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<ItemDTO> pageQuery(Pageable pageable) {
        Page<Item> itemPage = itemService.findAll(pageable);
        List<ItemDTO> dtoList = itemPage
                .stream()
                .map(itemMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, itemPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public ItemDTO update(@RequestBody ItemDTO itemDTO, @PathVariable("id") Integer id) {
        Item item = itemMapper.asEntity(itemDTO);
        return itemMapper.asDTO(itemService.update(item, id));
    }
}