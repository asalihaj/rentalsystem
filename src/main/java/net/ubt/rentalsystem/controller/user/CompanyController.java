package net.ubt.rentalsystem.controller.user;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.dto.auth.AuthenticationResponse;
import net.ubt.rentalsystem.dto.user.RegisterCompanyDto;
import net.ubt.rentalsystem.service.user.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerCompany(@RequestBody  RegisterCompanyDto registerCompanyDto) {
        return new ResponseEntity<>(companyService.registerCompany(registerCompanyDto), HttpStatus.OK);
    }
}
