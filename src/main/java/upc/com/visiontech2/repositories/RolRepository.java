package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upc.com.visiontech2.entities.Role;

@Repository
public interface RolRepository extends JpaRepository<Role, Long> {
}
