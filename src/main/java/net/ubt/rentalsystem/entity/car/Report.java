package net.ubt.rentalsystem.entity.car;

import jakarta.persistence.*;
import lombok.Data;
import net.ubt.rentalsystem.entity.user.User;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column
    private String message;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ReportCategory category;
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
}
