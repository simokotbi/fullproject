package com.ahmed.fullproject.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ahmed.fullproject.service.EmployeeDerailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Order(1)
public class SecurityConfig {



  /*  @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }*/
  private final EmployeeDerailsService employeeDerailsService;

    public SecurityConfig(EmployeeDerailsService employeeDerailsService) {
        this.employeeDerailsService = employeeDerailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    /*
        http.headers().frameOptions().disable();
        http.csrf().disable()
                .authorizeRequests().antMatchers("/index",
                        "/add-employee","/employeenamestable","/new-order").authenticated()
                .and()
                .formLogin().loginPage("/employee/emp-login").loginProcessingUrl("/emp-login").defaultSuccessUrl("/employee/home")//successForwardUrl("/employee/home")
                .and().userDetailsService(employeeDerailsService);
        return http.build();
    }

     */

        http.antMatcher("/employee/**")
                .authorizeRequests().anyRequest().hasAuthority("EMPLOYEE")
                .and()
                .formLogin()
                .loginPage("/employee/login")
                .usernameParameter("username")
                //.successForwardUrl("/employee/home")
                .loginProcessingUrl("/employee/login")

                .defaultSuccessUrl("/employee/home")
                .permitAll()
                    .and().userDetailsService(employeeDerailsService);
        return http.build();
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}
