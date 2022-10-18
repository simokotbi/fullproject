package com.ahmed.fullproject.controller.impl;

import com.ahmed.fullproject.controller.OrderController;
import com.ahmed.fullproject.dto.OrderDTO;
import com.ahmed.fullproject.entity.Order;
import com.ahmed.fullproject.mapper.OrderMapper;
import com.ahmed.fullproject.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/order")
@RestController
public class OrderControllerImpl implements OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderControllerImpl(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO save(@RequestBody OrderDTO orderDTO) {
        Order order = orderMapper.asEntity(orderDTO);
        return orderMapper.asDTO(orderService.save(order));
    }

    @Override
    @GetMapping("/{id}")
    public OrderDTO findById(@PathVariable("id") Integer id) {
        Order order = orderService.findById(id).orElse(null);
        return orderMapper.asDTO(order);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        orderService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<OrderDTO> list() {
        return orderMapper.asDTOList(orderService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<OrderDTO> pageQuery(Pageable pageable) {
        Page<Order> orderPage = orderService.findAll(pageable);
        List<OrderDTO> dtoList = orderPage
                .stream()
                .map(orderMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, orderPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public OrderDTO update(@RequestBody OrderDTO orderDTO, @PathVariable("id") Integer id) {
        Order order = orderMapper.asEntity(orderDTO);
        return orderMapper.asDTO(orderService.update(order, id));
    }
}