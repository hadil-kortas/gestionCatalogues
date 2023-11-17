package com.poly.gestioncataloguesg1.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    private Integer id;
    @NotEmpty
    @Size(min = 1, max = 20)
    private String nom;
    @Min(1)
    private double prix;
    @Min(0)
    private int quantite;
    @ManyToOne
    @NotNull(message = "category should not be null")
    private Categorie categorie;

}

