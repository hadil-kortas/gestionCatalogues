package com.poly.gestioncataloguesg1.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
// Entity anotation pour dire que la classe produit est persistente
public class Produit {
    @Id // primary key de l'id dans la table produit
    @GeneratedValue(strategy = GenerationType.IDENTITY) // l'id est auto increment dans la base de donnée
    private Long id;
    private String nom;
    private double prix;
    private int quantite;
    @ManyToOne
    private Categorie categorie;
}
