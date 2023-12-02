package net.ubt.rentalsystem.entity.location;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Country country;
}
