package net.ubt.rentalsystem.controller.user;

import lombok.RequiredArgsConstructor;
import net.ubt.rentalsystem.config.JwtService;
import net.ubt.rentalsystem.dto.user.RegisterCompanyDto;
import net.ubt.rentalsystem.dto.user.RegisterEmployeeDto;
import net.ubt.rentalsystem.service.user.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<HttpStatus> registerCompany(@RequestBody  RegisterCompanyDto registerCompanyDto) {
        companyService.registerCompany(registerCompanyDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register-employee")
    public ResponseEntity<HttpStatus> registerEmployee(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody RegisterEmployeeDto registerEmployeeDto
    ) {
        String companyId = jwtService.extractClaim(token.substring(7), "companyId");
        if (companyId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        companyService.registerEmployee(UUID.fromString(companyId), registerEmployeeDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
