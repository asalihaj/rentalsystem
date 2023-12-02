package net.ubt.rentalsystem.entity.user;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Entity
public class CustomRole {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        return permissions
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                .collect(Collectors.toList());
    }
}
