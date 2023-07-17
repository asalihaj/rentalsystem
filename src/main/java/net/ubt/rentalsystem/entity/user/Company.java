package net.ubt.rentalsystem.entity.user;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.UUID;

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
}
