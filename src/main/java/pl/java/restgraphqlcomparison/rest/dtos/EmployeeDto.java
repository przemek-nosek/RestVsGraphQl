package pl.java.restgraphqlcomparison.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeDto {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final String extension;
    private final String email;
    private final String jobTitle;
}
