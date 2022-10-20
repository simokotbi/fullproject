package com.ahmed.fullproject.controller.impl;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {



        @GetMapping("")
        public String viewHomePage() {
            return "index";
        }

        @GetMapping("/employee/login")
        public String viewAdminLoginPage() {
            return "employee/emp-login";
        }

        @GetMapping("/employee/home")
        public String viewEmployeeHomePage() {
            return "employee/employee-home";
        }

        @GetMapping("/customer/login")
        public String viewCustomerLoginPage() {
            return "customer/clientLogin";
        }

        @GetMapping("/customer/home")
        public String viewCustomerHomePage() {
            return "customer/customer-home";
        }


    }
