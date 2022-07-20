package com.site.SDE.RestController;


import com.site.SDE.Entite.Formateur;
import com.site.SDE.Service.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/formateur")
public class FormateurRestController {

    @Autowired
    public FormateurService formateurService;

    @RequestMapping(method = RequestMethod.POST)
    public Formateur ajouterFormateur(@RequestBody Formateur formateur){
        return formateurService.ajouterFormateur(formateur);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Formateur modifierFormateur(@PathVariable("id")Long id,@RequestBody Formateur formateur){
        Formateur newFormateur=formateurService.modifierFormateur(formateur);
        return newFormateur;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Formateur> listFormateur(){
        return formateurService.listFormateur();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerFormateur(@PathVariable("id")Long id){
        formateurService.supprimerFormateur(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Optional<Formateur> getFormateurById(@PathVariable("id")Long id){
        Optional<Formateur>formateur=formateurService.getFormateurById(id);
        return formateur;
    }


}
