package com.ahmed.fullproject.controller.impl;

import com.ahmed.fullproject.dto.CustomerDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


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
        public String viewAdminHomePage() {
            return "employee/employee-home";
        }

        @GetMapping("/customer/login")
        public String viewUserLoginPage() {
            return "customer/clientLogin";
        }

        @GetMapping("/customer/home")
        public String viewUserHomePage() {
            return "customer/customer-home";
        }

      //test
    }
