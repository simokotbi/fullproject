package com.ahmed.fullproject.controller.impl;

// import com.ahmed.fullproject.controller.CustomerController;
// import com.ahmed.fullproject.dto.CustomerDTO;
// import com.ahmed.fullproject.entity.Customer;
// import com.ahmed.fullproject.mapper.CustomerMapper;
// import com.ahmed.fullproject.service.CustomerService;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageImpl;
// import org.springframework.data.domain.Pageable;
// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.stream.Collectors;

//@RequestMapping("/customer")
//@RestController
public class CustomerControllerImpl {/*implements CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;


    public CustomerControllerImpl(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO save(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerMapper.asEntity(customerDTO);
        return customerMapper.asDTO(customerService.save(customer));
    }

    @Override
    @GetMapping("/{id}")
    public CustomerDTO findById(@PathVariable("id") Integer id) {
        Customer customer = customerService.findById(id).orElse(null);
        return customerMapper.asDTO(customer);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        customerService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<CustomerDTO> list() {
        return customerMapper.asDTOList(customerService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<CustomerDTO> pageQuery(Pageable pageable) {
        Page<Customer> customerPage = customerService.findAll(pageable);
        List<CustomerDTO> dtoList = customerPage
                .stream()
                .map(customerMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, customerPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO, @PathVariable("id") Integer id) {
        Customer customer = customerMapper.asEntity(customerDTO);
        return customerMapper.asDTO(customerService.update(customer, id));
    }*/
}