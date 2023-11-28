package net.ubt.rentalsystem.entity.booking;

import jakarta.persistence.*;
import lombok.Data;
import net.ubt.rentalsystem.entity.car.Car;
import net.ubt.rentalsystem.entity.user.Client;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false)
    private OffsetDateTime rentalDate;
    @Column(nullable = false)
    private OffsetDateTime returnDate;
    @Column(nullable = false)
    private BigDecimal totalPrice;
    @Column
    private String notes;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
}
