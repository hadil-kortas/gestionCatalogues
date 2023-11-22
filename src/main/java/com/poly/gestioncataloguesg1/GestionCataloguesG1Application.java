package com.poly.gestioncataloguesg1;

import com.poly.gestioncataloguesg1.dao.CategorieRepository;
import com.poly.gestioncataloguesg1.dao.ProduitRepository;
import com.poly.gestioncataloguesg1.entities.Categorie;
import com.poly.gestioncataloguesg1.entities.Produit;
import com.poly.gestioncataloguesg1.service.ServiceProduit;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class GestionCataloguesG1Application implements CommandLineRunner {
    //@Autowired
    private CategorieRepository categorieRepository;
    //@Autowired
    private ProduitRepository produitRepository;



    /*public GestionCataloguesG1Application(CategorieRepository categorieRepository, ProduitRepository produitRepository) {
        this.categorieRepository = categorieRepository;
        this.produitRepository = produitRepository;
    }*/

    public static void main(String[] args) {

        SpringApplication.run(GestionCataloguesG1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        categorieRepository.save(new Categorie(null, "informatique", null));
        categorieRepository.save(new Categorie(null, "Génie civile", null));
        categorieRepository.save(new Categorie(null, "informatique de gestion", null));
        //produitRepository.save(new Produit(null, "ecran", 500, 5, categorieRepository.findById(1L).get()));
        //produitRepository.save(new Produit(null, "pc portable", 3000, 5, categorieRepository.findById(1L).get()));
        //produitRepository.save(new Produit(null, "souris", 25, 7, categorieRepository.findById(1L).get()));
        //produitRepository.findByNomContains("e");
        produitRepository.getProductsByCat(1L);

        // nzid .get bech traja3li catégorie
        //1L khater Long


    }
}
// l constructeur ya3mel injection w y3awedh l auto wired
// Allargsconstructor t3awedh l constrecteur

//ou bien nkhali ken essem l classe w nesta3mel annotation @Bean pour l'éxcuter au démarage

/*
@Bean
CommandLineRunner commandLineRunner (CategorieRepository categorieRepository, ProduitRepository ProduitRepository)
{
    return args ->{
        categorieRepository.save(new Categorie(null, "informatique", null));
        categorieRepository.save(Categorie.builder().nom("electronique").build());
    };
   }
  }
 */