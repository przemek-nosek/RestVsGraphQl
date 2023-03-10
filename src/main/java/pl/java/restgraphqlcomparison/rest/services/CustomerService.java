package pl.java.restgraphqlcomparison.rest.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.java.restgraphqlcomparison.rest.dtos.CustomerDetailedInfoDto;
import pl.java.restgraphqlcomparison.rest.dtos.CustomerDto;
import pl.java.restgraphqlcomparison.rest.mappers.CustomerMapper;
import pl.java.restgraphqlcomparison.common.repositories.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public Page<CustomerDto> getCustomers(Pageable page) {
        return customerRepository.findAll(page)
                .map(customerMapper::toCustomerDto);
    }

    @Transactional
    public CustomerDetailedInfoDto getCustomerDetailedInfo(long customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::toCustomerDetailedInfoDto)
                .orElseThrow();
    }

    public CustomerDto getCustomer(long customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::toCustomerDto)
                .orElseThrow();
    }

    public void createCustomer(CustomerDto customerDto) {
        customerRepository.save(customerMapper.toCustomer(customerDto));
    }

    public void updateCustomer(long customerId, CustomerDto customerDto) {
        if(!customerRepository.existsById(customerId)){
            throw new RuntimeException("Customer does not exist.");
        }
        customerRepository.save(customerMapper.toCustomer(customerDto));
    }

    public void deleteCustomer(long customerId) {
        if(!customerRepository.existsById(customerId)){
            throw new RuntimeException("Customer does not exist.");
        }
        customerRepository.deleteById(customerId);
    }
}
