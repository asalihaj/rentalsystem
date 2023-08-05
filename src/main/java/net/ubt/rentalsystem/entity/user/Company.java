package net.ubt.rentalsystem.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import net.ubt.rentalsystem.entity.car.Equipment;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @OneToOne
    private User user;
    @OneToMany(mappedBy = "company")
    private Set<Equipment> equipments;
    @OneToMany(mappedBy = "company")
    private Set<SocialMedia> socialMedias;
    @OneToMany(mappedBy = "company")
    private Set<Employee> employees;
}
