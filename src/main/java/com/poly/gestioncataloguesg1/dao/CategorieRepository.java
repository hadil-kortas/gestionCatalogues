package com.poly.gestioncataloguesg1.dao;

import com.poly.gestioncataloguesg1.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
}
//jpa: java persistence api