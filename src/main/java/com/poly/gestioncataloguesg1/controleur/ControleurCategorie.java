package com.poly.gestioncataloguesg1.controleur;

import com.poly.gestioncataloguesg1.entities.Categorie;
import com.poly.gestioncataloguesg1.entities.Produit;
import com.poly.gestioncataloguesg1.service.ServiceCategorie;
import com.poly.gestioncataloguesg1.service.ServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor

public class ControleurCategorie {
    ServiceProduit serviceProduit;
    ServiceCategorie serviceCategorie;

    @GetMapping("/categories")
    public String getAllCategories(Model m)
    {
        List<Categorie> categories=serviceCategorie.getAllCategories();
        m.addAttribute("categories",categories);

        return "categories";
    }
}
