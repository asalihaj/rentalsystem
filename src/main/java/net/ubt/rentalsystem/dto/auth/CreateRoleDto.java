package net.ubt.rentalsystem.dto.auth;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class CreateRoleDto {
    private String name;
    private String description;
    private UUID userId;
    private Set<UUID> permissions;
}
