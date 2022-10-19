package com.ahmed.fullproject.controller.impl;

// import com.ahmed.fullproject.controller.EmployeeController;
// import com.ahmed.fullproject.dto.EmployeeDTO;
// import com.ahmed.fullproject.entity.Employee;
// import com.ahmed.fullproject.mapper.EmployeeMapper;
// import com.ahmed.fullproject.service.EmployeeService;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageImpl;
// import org.springframework.data.domain.Pageable;
// import org.springframework.http.HttpStatus;
// import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.stream.Collectors;

//@RequestMapping("/employee")
//@RestController
//@Controller
public class EmployeeControllerImpl{ /*implements EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeControllerImpl(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }


    //@PreAuthorize("hasRole('USER')")



    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.asEntity(employeeDTO);
        return employeeMapper.asDTO(employeeService.save(employee));
    }

    @Override
    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable("id") Integer id) {
        Employee employee = employeeService.findById(id).orElse(null);
        return employeeMapper.asDTO(employee);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        employeeService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<EmployeeDTO> list() {
        return employeeMapper.asDTOList(employeeService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<EmployeeDTO> pageQuery(Pageable pageable) {
        Page<Employee> employeePage = employeeService.findAll(pageable);
        List<EmployeeDTO> dtoList = employeePage
                .stream()
                .map(employeeMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, employeePage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO, @PathVariable("id") Integer id) {
        Employee employee = employeeMapper.asEntity(employeeDTO);
        return employeeMapper.asDTO(employeeService.update(employee, id));
    }*/
}