package com.poly.gestioncataloguesg1.service;

import com.poly.gestioncataloguesg1.entities.Categorie;

import java.util.List;

public interface IServiceCategorie {

    public void saveCategorie(Categorie c);
    public List<Categorie> getAllCategories();
    public List<Categorie> getCategorieByMc(String mc);
    public void deleteCategorie(Long id);
    public Categorie getCategorie (Long id);

}
