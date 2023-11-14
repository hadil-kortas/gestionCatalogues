package com.poly.gestioncataloguesg1.controleur;

import com.poly.gestioncataloguesg1.entities.Produit;
import com.poly.gestioncataloguesg1.service.ServiceCategorie;
import com.poly.gestioncataloguesg1.service.ServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@AllArgsConstructor

public class ControleurProduit {

    ServiceProduit serviceProduit;
    ServiceCategorie serviceCategorie;
    @GetMapping("/index")
    public String getAllProducts(Model m, @RequestParam(name = "mc", defaultValue = "") String mc)
    {
        List<Produit>l=serviceProduit.getProductByMc(mc);
        m.addAttribute("products",l);

        return "vue";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long idProduit)
    {
        serviceProduit.deleteProduct(idProduit);
        return "redirect:/index";
    }

    @GetMapping("/formajout")
    public String form(Model m)
    {
        m.addAttribute("categories", serviceCategorie.getAllCategories());
        return "ajouterProduit";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable("id") Long id, Model model) {
        Produit produit = serviceProduit.getProduct(id);
        model.addAttribute("product", produit);
        return "voirProduit"; // Create a new HTML template for viewing a single product
    }




}
