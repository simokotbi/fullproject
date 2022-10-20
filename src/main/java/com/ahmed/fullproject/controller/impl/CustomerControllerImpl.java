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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//@RequestMapping("/customer")
//@RestController
@Controller
public class CustomerControllerImpl  {

    @Autowired
    CustomerRepository customerRepository;




    @RequestMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "clientRegister";
    }
    //registration start

/*    @ModelAttribute("customer")
    public CustomerDTO userRegistrationDto() {
        return new CustomerDTO();
    }*/


    @PostMapping("/clientRegister")
    public String clientRegister(Customer customer) {
    customerRepository.save(customer);

       /* redirectAttributes.addFlashAttribute("message",
                "Thanks for contacting us! We will get in touch with you shortly.");*/
        return "redirect:/customer/login";

    }

    /*   @GetMapping("/customer/order")
       public String showOrderForm(Model model) {
           model.addAttribute("order", new Order());

           return "customer/order";
       }
    @PostMapping("/customer/order")
    public String clientNeworder(Order order) {
        orderRepository.save(order);

        return "redirect:/customer/home";

    }

     */
}