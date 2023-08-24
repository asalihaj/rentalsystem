package net.ubt.rentalsystem.entity.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User appUser;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
