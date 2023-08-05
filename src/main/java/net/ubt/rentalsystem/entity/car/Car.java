package net.ubt.rentalsystem.entity.car;

import jakarta.persistence.*;
import lombok.Data;
import net.ubt.rentalsystem.entity.user.Company;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false)
    private Short productionYear;
    @Column(nullable = false)
    private BigDecimal rentalRate;
    @Column(nullable = false)
    private Short seats;
    @Column(nullable = false)
    private Short doors;
    @Column(unique = true, nullable = false)
    private String plateNumber;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;
    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;
    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    @OneToMany
    private Set<Photo> photos;

    @ManyToMany
    @JoinTable(
            name = "car_utility",
            joinColumns = @JoinColumn(name = "car_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "utility_id", nullable = false)
    )
    private Set<Utility> utilities;
    @ManyToMany
    @JoinTable(
            name = "car_insurance",
            joinColumns = @JoinColumn(name = "car_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "insurance_id", nullable = false)
    )
    private Set<Insurance> insurances;
}
