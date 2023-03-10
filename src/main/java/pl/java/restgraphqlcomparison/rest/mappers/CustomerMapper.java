package pl.java.restgraphqlcomparison.rest.mappers;

import org.mapstruct.Mapper;
import pl.java.restgraphqlcomparison.common.entities.Customer;
import pl.java.restgraphqlcomparison.rest.dtos.CustomerDetailedInfoDto;
import pl.java.restgraphqlcomparison.rest.dtos.CustomerDto;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toCustomerDto(Customer customers);

    CustomerDetailedInfoDto toCustomerDetailedInfoDto(Customer customer);

    Customer toCustomer(CustomerDto customerDto);
}
