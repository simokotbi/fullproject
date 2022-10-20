package com.ahmed.fullproject.controller.impl;


import com.ahmed.fullproject.entity.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {



        @GetMapping("")
        public String viewHomePage() {
            return "index";
        }

        @GetMapping("/employee/login")
        public String viewAdminLoginPage() {
            return "employee/EmployeeLogin";
        }

   /*     @GetMapping("/employee/home")
        public String viewEmployeeHomePage() {
            return "employee/employee-order";
        }
*/
    @GetMapping("/employee/neworder")
    public String viewEmployeeorderPage() {
        return "new-order";
    }
        @GetMapping("/customer/login")
        public String viewCustomerLoginPage() {
            return "customer/clientLogin";
        }

        @GetMapping("/customer/home")
        public String viewCustomerHomePage() {
            return "customer/customerneworder";
            //customer-home
        }






}
