package com.poly.gestioncataloguesg1.controleur;

import com.poly.gestioncataloguesg1.entities.Categorie;
import com.poly.gestioncataloguesg1.entities.Produit;
import com.poly.gestioncataloguesg1.service.ServiceCategorie;
import com.poly.gestioncataloguesg1.service.ServiceProduit;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@Controller
@AllArgsConstructor

public class ControleurProduit {

    ServiceProduit serviceProduit;
    ServiceCategorie serviceCategorie;
    @GetMapping("/user/index")
    public String getAllProducts(Model m,
                                 @RequestParam(name = "mc", defaultValue = "") String mc,
                                 @RequestParam(name = "page", defaultValue = "0")int page,
                                 @RequestParam(name = "size", defaultValue = "5") int size)
    {
        Page<Produit> l=serviceProduit.getProductByMc(mc, PageRequest.of(page,size));
        m.addAttribute("mc",mc);
        m.addAttribute("products",l.getContent());
        m.addAttribute("pages", new int[l.getTotalPages()]);
        m.addAttribute("currentpage", l.getNumber());

        return "vue";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long idProduit)
    {
        serviceProduit.deleteProduct(idProduit);
        return "redirect:/user/index";
    }

    @GetMapping("/admin/addProduct")
    public String addForm(Model m)
    {
        m.addAttribute("produit", new Produit());
        m.addAttribute("categories", serviceCategorie.getAllCategories());
        return "ajouterProduit";
    }

    @PostMapping("/admin/addProduct")
    public String saveProduct(@Valid Produit p, BindingResult bindingResult, Model m, @RequestParam("image") MultipartFile mf) throws IOException {
        if (bindingResult.hasErrors()) {
            m.addAttribute("categories", serviceCategorie.getAllCategories());
            return "ajouterProduit";
        }
        serviceProduit.saveProduct(p,mf);
        return "redirect:/user/index";
    }

    @GetMapping("/user/product/{id}")
    public String getProduct(@PathVariable("id") Long id, Model model) {
        Produit produit = serviceProduit.getProduct(id);
        model.addAttribute("product", produit);
        return "voirProduit"; // Create a new HTML template for viewing a single product
    }

    @GetMapping("/admin/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model ) {
        Produit produit = serviceProduit.getProduct(id);
        model.addAttribute("product", produit);
        model.addAttribute("categories", serviceCategorie.getAllCategories());
        return "editProduit";
    }

    @PostMapping("/admin/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, @ModelAttribute Produit editedProduct, @RequestParam("image") MultipartFile mf) throws IOException {
        serviceProduit.editProduct(id, editedProduct, mf);
        return "redirect:/user/index";
    }

   @GetMapping("/")
    public String home()
   {
       return "redirect:/user/index";
   }








}
