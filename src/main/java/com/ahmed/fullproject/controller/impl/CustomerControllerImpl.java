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

import com.ahmed.fullproject.controller.CustomerController;
import com.ahmed.fullproject.dao.CustomerRepository;
import com.ahmed.fullproject.dto.CustomerDTO;
import com.ahmed.fullproject.entity.Customer;
import com.ahmed.fullproject.mapper.CustomerMapper;
import com.ahmed.fullproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//@RequestMapping("/customer")
//@RestController
@Controller
public class CustomerControllerImpl implements CustomerController {
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
        @Autowired
       CustomerRepository customerRepository;
    public CustomerControllerImpl(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

/*  @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO save(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerMapper.asEntity(customerDTO);
        return customerMapper.asDTO(customerService.save(customer));
    }*/




    @GetMapping("/customer/Register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer/clientRegister";
    }
    //registration start

    @ModelAttribute("customer")
    public CustomerDTO userRegistrationDto() {
        return new CustomerDTO();
    }


    @PostMapping("/customer/clientRegister")
    public String clientRegister(@ModelAttribute("customer") Customer customer, BindingResult result,
                                      RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "/";
        }
        customerMapper.asDTO(customerService.save(customer));


       /* redirectAttributes.addFlashAttribute("message",
                "Thanks for contacting us! We will get in touch with you shortly.");*/
        return "redirect:/customer/login";

    }










    //registration end

    @Override
    public CustomerDTO save(CustomerDTO customer) {
        return null;
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
    @GetMapping("/findall")
    public List<CustomerDTO> list() {
        return customerMapper.asDTOList(customerService.findAll());
    }

    @Override
    public CustomerDTO update(CustomerDTO dto, Integer id) {
        return null;
    }

   /* @Override
    @GetMapping("/page-query")
    public Page<CustomerDTO> pageQuery(Pageable pageable) {
        Page<Customer> customerPage = customerService.findAll(pageable);
        List<CustomerDTO> dtoList = customerPage
                .stream()
                .map(customerMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, customerPage.getTotalElements());
    }

    */



}