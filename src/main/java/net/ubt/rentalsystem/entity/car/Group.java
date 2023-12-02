package net.ubt.rentalsystem.entity.car;

import jakarta.persistence.*;
import lombok.Data;
import net.ubt.rentalsystem.entity.user.Company;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "car_group")
public class Group {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;
    @OneToMany(mappedBy = "group")
    private Set<Car> cars;

    @ManyToMany
    @JoinTable(
            name = "equipment_group",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private Set<Equipment> equipments;
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    @ManyToMany
    @JoinTable(
            name = "group_period",
            joinColumns = @JoinColumn(name = "group_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "period_id", nullable = false)
    )
    private Set<Period> periods;
}
