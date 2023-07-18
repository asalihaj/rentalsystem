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
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer coverValue;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Boolean isFixed;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToMany(mappedBy = "insurances")
    private Set<Car> cars;
}
