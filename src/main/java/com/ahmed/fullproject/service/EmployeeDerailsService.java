package com.ahmed.fullproject.service;


import com.ahmed.fullproject.dao.EmployeeRepository;
import com.ahmed.fullproject.modules.SecurityEmployee;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
    public class EmployeeDerailsService implements UserDetailsService {

        private final EmployeeRepository employeeRepository;



    public EmployeeDerailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return employeeRepository
                    .findByUsername(username)
                    .map(SecurityEmployee::new)
                    .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
        }
}
