package net.ubt.rentalsystem.dto.car;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class GroupDto {
    private String name;
    private String description;
    private OffsetDateTime createdAt;
    private OffsetDateTime lastUpdate;
}
