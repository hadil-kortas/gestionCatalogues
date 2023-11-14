package com.poly.gestioncataloguesg1.service;

import com.poly.gestioncataloguesg1.dao.ProduitRepository;
import com.poly.gestioncataloguesg1.entities.Produit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class ServiceProduit implements IServiceProduit{

    private ProduitRepository produitRepository;

    @Override
    public void saveProduct(Produit p) {
        produitRepository.save(p);

    }

    @Override
    public List<Produit> getAllProducts() {
        return produitRepository.findAll();
    }

    @Override
    public List<Produit> getProductByMc(String mc) {
        return produitRepository.findByNomContains(mc);
    }

    @Override
    public List<Produit> getProductByCat(Long idCat) {
        return produitRepository.getProductsByCat(idCat);
    }

    @Override
    public void deleteProduct(Long id) {
        produitRepository.deleteById(id);

    }

    @Override
    public Produit getProduct(Long id) {
        return produitRepository.findById(id).orElse(null);
    }
}
