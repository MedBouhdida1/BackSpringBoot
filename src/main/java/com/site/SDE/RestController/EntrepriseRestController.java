package com.site.SDE.RestController;


import com.site.SDE.Entite.Entreprise;
import com.site.SDE.Service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/entreprise")
public class EntrepriseRestController {

    @Autowired
    EntrepriseService entrepriseService;

    @RequestMapping(method = RequestMethod.POST)
    public Entreprise ajouterEntreprise(@RequestBody Entreprise entreprise){
        return entrepriseService.ajouterEntreprise(entreprise);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Entreprise modifierEnterprise(@PathVariable("id")Long id,@RequestBody Entreprise entreprise){
        Entreprise newEntreprise=entrepriseService.modifierEntreprise(entreprise);
        return newEntreprise;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerEntreprise(@PathVariable("id")Long id){
        entrepriseService.supprimerEntreprise(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Optional<Entreprise>getEnterpriseById(@PathVariable("id")Long id){
        Optional<Entreprise>entreprise=entrepriseService.getEntrepriseById(id);
        return entreprise;
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Entreprise> lstEntreprise(){
        return entrepriseService.listEntreprise();
    }




}
