package net.ubt.rentalsystem.entity.user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private LocalDate birthday;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String notes;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @OneToOne(mappedBy = "client")
    private UserClient userClient;

    public enum Gender {
        MALE,
        FEMALE
    }
}
