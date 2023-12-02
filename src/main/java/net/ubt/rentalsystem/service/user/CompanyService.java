package net.ubt.rentalsystem.service.user;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.user.RegisterCompanyDto;
import net.ubt.rentalsystem.dto.user.RegisterEmployeeDto;
import net.ubt.rentalsystem.entity.user.*;
import net.ubt.rentalsystem.repository.user.CompanyRepository;
import net.ubt.rentalsystem.repository.user.EmployeeRepository;
import net.ubt.rentalsystem.repository.user.UserRepository;
import net.ubt.rentalsystem.service.auth.AuthService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final AuthService authService;

    public void registerCompany(RegisterCompanyDto registerCompanyDto) {
        registerCompanyDto.setRole(Role.COMPANY);
        authService.register(registerCompanyDto);
        User user = userRepository.findByEmail(registerCompanyDto.getEmail()).orElseThrow();

        Company company = new Company();
        company.setUser(user);
        company.setPhoneNumber(registerCompanyDto.getPhoneNumber());
        company.setLastUpdate(OffsetDateTime.now());
        company.setCreatedAt(OffsetDateTime.now());

        companyRepository.save(company);
    }

    public void registerEmployee(UUID companyId, RegisterEmployeeDto registerEmployeeDto) {
        registerEmployeeDto.setRole(Role.EMPLOYEE);
        authService.register(registerEmployeeDto);
        User user = userRepository.findByEmail(registerEmployeeDto.getEmail()).orElseThrow();

        Company company = new Company();
        company.setId(companyId);

        Employee employee = new Employee();
        employee.setCompany(company);
        employee.setAppUser(user);
        employee.setLastUpdate(OffsetDateTime.now());
        employee.setCreatedAt(OffsetDateTime.now());

        employeeRepository.save(employee);
    }
}
