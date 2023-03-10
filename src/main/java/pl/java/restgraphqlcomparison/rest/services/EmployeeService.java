package pl.java.restgraphqlcomparison.rest.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.java.restgraphqlcomparison.rest.dtos.EmployeeDto;
import pl.java.restgraphqlcomparison.rest.dtos.EmployeeWithCustomersDto;
import pl.java.restgraphqlcomparison.rest.mappers.EmployeeMapper;
import pl.java.restgraphqlcomparison.common.repositories.EmployeeRepository;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public Page<EmployeeDto> getEmployees(Pageable page) {
        return employeeRepository.findAll(page)
                .map(employeeMapper::toEmployeeDto);
    }

    @Transactional
    public EmployeeWithCustomersDto getEmployeeWithCustomersDto(long employeeId) {
        return employeeRepository.findById(employeeId)
                .map(employeeMapper::toEmployeeWithCustomersDto)
                .orElseThrow();
    }

    public EmployeeDto getEmployee(long employeeId) {
        return employeeRepository.findById(employeeId)
                .map(employeeMapper::toEmployeeDto)
                .orElseThrow();
    }

    public void createEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(employeeMapper.toEmployee(employeeDto));
    }

    public void updateEmployee(long employeeId, EmployeeDto employeeDto) {
        if(!employeeRepository.existsById(employeeId)){
            throw new RuntimeException("Employee does not exist.");
        }
        employeeRepository.save(employeeMapper.toEmployee(employeeDto));
    }

    public void deleteEmployee(long employeeId) {
        if(!employeeRepository.existsById(employeeId)){
            throw new RuntimeException("Employee does not exist.");
        }
        employeeRepository.deleteById(employeeId);
    }
}
