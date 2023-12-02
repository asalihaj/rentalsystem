package net.ubt.rentalsystem.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.ubt.rentalsystem.entity.user.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private Role role;
}
