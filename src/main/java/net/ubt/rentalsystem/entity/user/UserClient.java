package net.ubt.rentalsystem.entity.user;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "user_client")
public class UserClient {
    @Id
    private UUID id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
