package pl.java.restgraphqlcomparison.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomerDto {
    private final long id;
    private final String name;
    private final String contactFirstName;
    private final String contactLastName;
    private final String phone;
    private final String addressLine1;
    private final String addressLine2;
    private final String city;
    private final String state;
    private final String postalCode;
    private final String creditLimit;
}
