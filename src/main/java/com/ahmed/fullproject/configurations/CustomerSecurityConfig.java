package com.ahmed.fullproject.configurations;

import com.ahmed.fullproject.service.CustomerDerailsService;
import com.ahmed.fullproject.service.EmployeeDerailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Order(2)
public class CustomerSecurityConfig {



  /*  @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }*/
  private final CustomerDerailsService customerDerailsService;

    public CustomerSecurityConfig(CustomerDerailsService customerDerailsService) {
        this.customerDerailsService = customerDerailsService;
    }

    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {


        http.antMatcher("/customer/**")
                .authorizeRequests().anyRequest().hasAuthority("CUSTOMER")
                .and()
                .formLogin()
                .loginPage("/customer/login")
                .usernameParameter("username")
                //.successForwardUrl("/customer/home")
                .loginProcessingUrl("/customer/login")

                .defaultSuccessUrl("/customer/customer-home")
                .permitAll()
                    .and().userDetailsService(customerDerailsService);
        return http.build();
    }
  /*  @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }*/


}
