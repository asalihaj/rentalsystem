package net.ubt.rentalsystem.repository.car;

import net.ubt.rentalsystem.entity.car.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
    List<Group> findAllByCompanyId(UUID companyId);
}