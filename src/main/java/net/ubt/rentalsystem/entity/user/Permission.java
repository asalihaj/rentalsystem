package net.ubt.rentalsystem.entity.user;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;


@Entity
@Data
public class Permission {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;
}
