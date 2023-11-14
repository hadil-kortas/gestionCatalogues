package com.poly.gestioncataloguesg1.service;

import com.poly.gestioncataloguesg1.entities.Produit;

import java.util.List;

public interface IServiceProduit {

    public void saveProduct(Produit p);
    public List<Produit> getAllProducts();
    public List<Produit> getProductByMc(String mc);
    public List<Produit> getProductByCat(Long idCat);
    public void deleteProduct(Long id);
    public Produit getProduct (Long id);


}
