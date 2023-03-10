package pl.java.restgraphqlcomparison.graphql.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.java.restgraphqlcomparison.rest.dtos.CustomerDto;
import pl.java.restgraphqlcomparison.rest.services.CustomerService;

@RestController
@RequiredArgsConstructor
public class CustomerGraphQlController {

    private final CustomerService customerService;

    @QueryMapping
    public CustomerDto getCustomer(@Argument long id) {
        return customerService.getCustomer(id);
    }

    @QueryMapping
    public Page<CustomerDto> getCustomers(@Argument int page, @Argument int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return customerService.getCustomers(pageRequest);
    }
}
