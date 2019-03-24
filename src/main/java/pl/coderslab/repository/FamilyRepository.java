package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Family;

public interface FamilyRepository extends JpaRepository<Family, Long> {
}
