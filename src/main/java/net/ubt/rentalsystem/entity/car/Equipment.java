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
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Short maxPerOrder;
    @Column(nullable = false)
    private Boolean isFixed;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime lastUpadte;

    @ManyToMany(mappedBy = "equipments")
    private Set<Group> groups;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
