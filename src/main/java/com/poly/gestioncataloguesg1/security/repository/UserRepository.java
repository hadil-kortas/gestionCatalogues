package com.poly.gestioncataloguesg1.security.repository;

import com.poly.gestioncataloguesg1.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, String> {

    public AppUser findAppUserByUsername(String userName);
}
