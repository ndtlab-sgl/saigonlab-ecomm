package edu.sg.web.ecomm.repository;

import edu.sg.web.ecomm.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
}
