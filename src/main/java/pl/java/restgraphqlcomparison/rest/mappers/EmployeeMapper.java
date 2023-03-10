package pl.java.restgraphqlcomparison.rest.mappers;

import org.mapstruct.Mapper;
import pl.java.restgraphqlcomparison.common.entities.Employee;
import pl.java.restgraphqlcomparison.rest.dtos.EmployeeDto;
import pl.java.restgraphqlcomparison.rest.dtos.EmployeeWithCustomersDto;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toEmployeeDto(Employee employee);

    EmployeeWithCustomersDto toEmployeeWithCustomersDto(Employee employee);

    Employee toEmployee(EmployeeDto employeeDto);
}
