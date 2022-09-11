package com.site.SDE.RestController;


import com.site.SDE.Entite.Offres;
import com.site.SDE.Entite.OffresDto;
import com.site.SDE.Service.OffresService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/offres")
public class OffresRestController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    OffresService offresService;

    @RequestMapping(method = RequestMethod.POST)
    public OffresDto ajouterOffre(@RequestBody OffresDto offresDto){
        Offres offreRequest=modelMapper.map(offresDto,Offres.class);
        Offres offre=offresService.ajouterOffre(offreRequest);
        OffresDto offreResponse=modelMapper.map(offre,OffresDto.class);
        return offreResponse;
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
    public ResponseEntity<OffresDto> getOffreById(@PathVariable("id")Long id){
        Offres offre=offresService.getOffreById(id);
        OffresDto offresDto=modelMapper.map(offre,OffresDto.class);
        return ResponseEntity.ok().body(offresDto);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<OffresDto>lstOffres(){
        return offresService.lstOffres().stream().map(offres -> modelMapper.map(offres,OffresDto.class)).collect(Collectors.toList());
    }

    @RequestMapping(value = "/etat/{etat}",method = RequestMethod.GET)
    public List<OffresDto>getOffresByEtat(@PathVariable("etat")int etat){
        List<OffresDto>offre=offresService.getOffreByEtat(etat).stream().map(offres -> modelMapper.map(offres,OffresDto.class)).collect(Collectors.toList());
        return offre;
    }
}
