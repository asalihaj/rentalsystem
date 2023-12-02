package net.ubt.rentalsystem.entity.location;

import jakarta.persistence.*;
import lombok.Data;
import net.ubt.rentalsystem.entity.user.Company;

import java.util.UUID;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false)
    private String streetName;
    @Column(nullable = false)
    private String houseNumber;
    @Column(nullable = false)
    private String zipCode;

    @ManyToOne
    private City city;
}
