package com.poly.gestioncataloguesg1.service;


import com.poly.gestioncataloguesg1.dao.CategorieRepository;
import com.poly.gestioncataloguesg1.dao.ProduitRepository;
import com.poly.gestioncataloguesg1.entities.Categorie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ServiceCategorie implements IServiceCategorie{
    private CategorieRepository categorieRepository;
    @Override
    public void saveCategorie(Categorie c) {
        categorieRepository.save(c);

    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public List<Categorie> getCategorieByMc(String mc) {
        return null;
    }

    @Override
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);

    }

    @Override
    public Categorie getCategorie(Long id) {
        return null;
    }
}
