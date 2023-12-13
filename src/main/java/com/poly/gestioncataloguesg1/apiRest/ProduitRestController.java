package com.poly.gestioncataloguesg1.apiRest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.gestioncataloguesg1.entities.Produit;
import com.poly.gestioncataloguesg1.service.ServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*") //angular  localhost:4200
@RestController
@AllArgsConstructor
@RequestMapping("/api")

public class ProduitRestController {

    ServiceProduit serviceProduit;

    @GetMapping("/all")
    public List<Produit> getAllProducts(
                               @RequestParam(name = "mc", defaultValue = "") String mc,
                               @RequestParam(name = "page", defaultValue = "0")int page,
                               @RequestParam(name = "size", defaultValue = "5") int size)
    {
        Page<Produit> l=serviceProduit.getProductByMc(mc, PageRequest.of(page,size));

        return
                l.getContent();
    }

    @GetMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long idProduit)
    {
        serviceProduit.deleteProduct(idProduit);
    }


    @PostMapping("/add")
    //objet nrodou json w json nrodou objet
    public void saveProduct(@RequestParam("produit") String p, @RequestParam("fichier") MultipartFile mf) throws IOException {
        Produit produit = new ObjectMapper().readValue(p, Produit.class);

        serviceProduit.saveProduct(produit, mf);
    }




}
