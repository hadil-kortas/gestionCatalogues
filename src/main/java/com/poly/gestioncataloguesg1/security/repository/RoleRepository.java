package com.poly.gestioncataloguesg1.security.repository;

import com.poly.gestioncataloguesg1.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole, String> {
}
