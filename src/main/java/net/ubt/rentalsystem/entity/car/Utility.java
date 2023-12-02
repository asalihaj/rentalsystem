package net.ubt.rentalsystem.entity.car;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "utility")
public class Utility {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @ManyToMany(mappedBy = "utilities")
    private Set<Car> cars;
}
