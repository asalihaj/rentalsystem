package net.ubt.rentalsystem.service.user;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.auth.AuthenticationResponse;
import net.ubt.rentalsystem.dto.auth.RegisterRequest;
import net.ubt.rentalsystem.dto.user.RegisterCompanyDto;
import net.ubt.rentalsystem.entity.user.Company;
import net.ubt.rentalsystem.entity.user.User;
import net.ubt.rentalsystem.mapper.user.CompanyMapper;
import net.ubt.rentalsystem.repository.user.CompanyRepository;
import net.ubt.rentalsystem.repository.user.UserRepository;
import net.ubt.rentalsystem.service.auth.AuthService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final CompanyMapper companyMapper;

    public AuthenticationResponse registerCompany(RegisterCompanyDto registerCompanyDto) {
        RegisterRequest registerRequest = companyMapper.toUserRegister(registerCompanyDto);
        AuthenticationResponse token = authService.register(registerRequest);

        User user = userRepository.findByEmail(registerCompanyDto.getEmail()).orElseThrow();

        Company company = new Company();
        company.setUser(user);
        company.setPhoneNumber(registerCompanyDto.getPhoneNumber());
        company.setLastUpdate(OffsetDateTime.now());
        company.setCreatedAt(OffsetDateTime.now());

        companyRepository.save(company);

        return token;
    }
}
