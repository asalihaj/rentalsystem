package net.ubt.rentalsystem.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.OffsetDateTime;
import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private OffsetDateTime createdAt;
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<CustomRole> customRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var allPermissions = new HashSet<GrantedAuthority>();
        allPermissions.add(new SimpleGrantedAuthority("ROLE_" + role.name()));

        customRoles.stream()
                .map(CustomRole::getAuthorities)
                .forEach(allPermissions::addAll);

        return allPermissions;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
