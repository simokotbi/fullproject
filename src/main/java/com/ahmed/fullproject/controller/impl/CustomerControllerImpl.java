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

import com.ahmed.fullproject.dao.*;
import com.ahmed.fullproject.entity.CartItem;
import com.ahmed.fullproject.entity.Customer;
import com.ahmed.fullproject.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@RequestMapping("/customer")
//@RestController
@Controller
public class CustomerControllerImpl  {

    @Autowired
    CustomerRepository customerRepository;

@Autowired
ItemRepository itemRepository;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartItemRepository cartItemRepository;
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

    @GetMapping("/employee/home")
    public String showiproducts(Model model) {
      List<Item>item=itemRepository.findAll();
        model.addAttribute("products",item);
        return "employee/employee-order";
    }

    @PostMapping("/addToCart")
    public String addToCart(HttpServletRequest request, Model model, @RequestParam("itemId") Long id,
                            @RequestParam("name") String name) {

        CartItem cartItem=new CartItem();
        cartItem.setId(id);
        cartItemRepository.save(cartItem);

        return "redirect:/";
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