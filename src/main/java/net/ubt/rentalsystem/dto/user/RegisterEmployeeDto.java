package net.ubt.rentalsystem.dto.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.ubt.rentalsystem.dto.auth.RegisterRequest;

@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterEmployeeDto extends RegisterRequest {
}
