package com.ahmed.fullproject.service;


import com.ahmed.fullproject.dao.CustomerRepository;
import com.ahmed.fullproject.modules.SecurityEmployee;
import com.ahmed.fullproject.modules.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
    public class CustomerDerailsService implements UserDetailsService {

        private final CustomerRepository customerRepository;



    public CustomerDerailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return customerRepository
                    .findByUsername(username)
                    .map(SecurityUser::new)
                    .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
        }
}
