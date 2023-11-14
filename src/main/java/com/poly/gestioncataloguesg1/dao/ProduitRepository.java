package com.poly.gestioncataloguesg1.dao;

import com.poly.gestioncataloguesg1.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    public List<Produit> findByNomContains(String mc);
    @Query("select p from Produit p where p.categorie.id= :x")
    public List<Produit> getProductsByCat (@Param("x") Long idC);
}
// x indique idC