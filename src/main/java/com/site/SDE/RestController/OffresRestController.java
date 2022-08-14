package com.site.SDE.RestController;


import com.site.SDE.Entite.Offres;
import com.site.SDE.Service.OffresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/offres")
public class OffresRestController {

    @Autowired
    OffresService offresService;

    @RequestMapping(method = RequestMethod.POST)
    public Offres ajouterOffre(@RequestBody Offres offre){
        return offresService.ajouterOffre(offre);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Offres modifierOffre(@PathVariable("id")Long id,@RequestBody Offres offre){
        Offres newOffre=offresService.modifierOffre(offre);
        return newOffre;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerOffre(@PathVariable("id")Long id){
        offresService.supprimerOffre(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Optional<Offres>getOffreById(@PathVariable("id")Long id){
        Optional<Offres>offre=offresService.getOffreById(id);
        return offre;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Offres>lstOffres(){
        return offresService.lstOffres();
    }

    @RequestMapping(value = "/etat/{etat}",method = RequestMethod.GET)
    public List<Offres>getOffresByEtat(@PathVariable("etat")int etat){
        List<Offres>offre=offresService.getOffreByEtat(etat);
        return offre;
    }
}
