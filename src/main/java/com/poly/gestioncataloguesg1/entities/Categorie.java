package com.poly.gestioncataloguesg1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @JsonIgnore
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL) //mappedBy pour dire que l'autre extrimété est le maitre (Produit), mappedBy est utulisé toujours avec OnetoMany
    //One to Many
    //CascadeType.All : si j'ai suprimé une catégorie tous les produits seront supprimés
    List<Produit> produits;

}
