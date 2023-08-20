package net.ubt.rentalsystem.dto.user;

import lombok.Data;
import net.ubt.rentalsystem.entity.user.Role;

@Data
public class RegisterCompanyDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Role role = Role.COMPANY;
    private String phoneNumber;
}
