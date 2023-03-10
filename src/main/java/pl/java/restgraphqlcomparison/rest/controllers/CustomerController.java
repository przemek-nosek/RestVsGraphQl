package pl.java.restgraphqlcomparison.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import pl.java.restgraphqlcomparison.rest.dtos.CustomerDetailedInfoDto;
import pl.java.restgraphqlcomparison.rest.dtos.CustomerDto;
import pl.java.restgraphqlcomparison.rest.services.CustomerService;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public Page<CustomerDto> getCustomers(@PageableDefault Pageable page) {
        return customerService.getCustomers(page);
    }

    @GetMapping("/{customerId}/details")
    public CustomerDetailedInfoDto getCustomerDetailedInfo(@PathVariable long customerId) {
        return customerService.getCustomerDetailedInfo(customerId);
    }

    @GetMapping("/{customerId}")
    private CustomerDto getCustomer(@PathVariable long customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    private void createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.createCustomer(customerDto);
    }

    @PutMapping("/{customerId}")
    private void updateCustomer(@PathVariable long customerId, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping("/{customerId}")
    private void deleteCustomer(@PathVariable long customerId) {
        customerService.deleteCustomer(customerId);
    }
}
