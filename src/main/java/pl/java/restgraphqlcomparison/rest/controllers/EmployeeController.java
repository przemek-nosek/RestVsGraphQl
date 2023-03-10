package pl.java.restgraphqlcomparison.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import pl.java.restgraphqlcomparison.rest.dtos.CustomerDto;
import pl.java.restgraphqlcomparison.rest.dtos.EmployeeDto;
import pl.java.restgraphqlcomparison.rest.dtos.EmployeeWithCustomersDto;
import pl.java.restgraphqlcomparison.rest.services.EmployeeService;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public Page<EmployeeDto> getEmployees(@PageableDefault Pageable page) {
        return employeeService.getEmployees(page);
    }

    @GetMapping("/{employeeId}/details")
    public EmployeeWithCustomersDto getEmployeeWithCustomersDto(@PathVariable long employeeId) {
        return employeeService.getEmployeeWithCustomersDto(employeeId);
    }

    @GetMapping("/{employeeId}")
    private EmployeeDto getEmployee(@PathVariable long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    private void createEmployee(@RequestBody EmployeeDto customerDto) {
        employeeService.createEmployee(customerDto);
    }

    @PutMapping("/{employeeId}")
    private void updateEmployee(@PathVariable long employeeId, @RequestBody EmployeeDto customerDto) {
        employeeService.updateEmployee(employeeId, customerDto);
    }

    @DeleteMapping("/{employeeId}")
    private void deleteEmployee(@PathVariable long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}
