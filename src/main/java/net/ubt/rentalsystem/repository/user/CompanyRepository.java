package net.ubt.rentalsystem.repository.user;

import net.ubt.rentalsystem.entity.user.Company;
import net.ubt.rentalsystem.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    Optional<Company> findCompanyByUser(User user);
}
