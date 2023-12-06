package com.poly.gestioncataloguesg1.security.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {
    @Id
    private String id;

    @Column(unique = true)
    private String username;

    private String password;

    private String mail;

    @ManyToMany(fetch = FetchType.EAGER) // Many to par defaut lasy a7na n7ebou nrodoha eager
    private List<AppRole> roles;
}
