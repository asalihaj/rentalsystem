package net.ubt.rentalsystem.repository.user;

import net.ubt.rentalsystem.entity.user.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SocialMediaRepository extends JpaRepository<SocialMedia, UUID> {
}
