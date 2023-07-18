package net.ubt.rentalsystem.entity.car;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name= "color")
public class Color {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String hexCode;
    @Column(nullable = false)
    private OffsetDateTime createdAt;

    @OneToMany(mappedBy = "color")
    private Set<Car> cars;
}
