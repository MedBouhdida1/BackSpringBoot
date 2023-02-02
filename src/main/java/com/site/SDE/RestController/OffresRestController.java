package com.site.SDE.RestController;


import com.site.SDE.Entite.Offres;
import com.site.SDE.Entite.OffresDto;
import com.site.SDE.Repository.OffresRepository;
import com.site.SDE.Service.OffresService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    OffresRepository offresRepository;

    @RequestMapping(method = RequestMethod.POST)
    public OffresDto ajouterOffre(@RequestBody OffresDto offresDto){
        Offres offreRequest=modelMapper.map(offresDto,Offres.class);
        Offres offre=offresService.ajouterOffre(offreRequest);
        OffresDto offreResponse=modelMapper.map(offre,OffresDto.class);
        return offreResponse;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public OffresDto modifierOffre(@PathVariable("id")Long id,@RequestBody OffresDto offreDto){
        Offres offresRequest=modelMapper.map(offreDto,Offres.class);
        Offres newOffre=offresService.modifierOffre(offresRequest);
        OffresDto offresResponse=modelMapper.map(newOffre,OffresDto.class);
        return offresResponse;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerOffre(@PathVariable("id")Long id){
        Optional<Offres> offre = offresRepository.findById(id);
        if(offre.isPresent()){
            offre.get().removeFormateurs();
            offresService.supprimerOffre(id);
        }
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
    @GetMapping("/offresbyfomateurid/{formateurId}")
    public ResponseEntity<List<OffresDto>> getAllOffresByFormateurId(@PathVariable(value = "formateurId") Long formateurId) {

        List<Offres> offres = offresRepository.findOffresByFormateurId(formateurId);
        List<OffresDto>offresDto=offres.stream().map(off->modelMapper.map(off,OffresDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(offresDto, HttpStatus.OK);
    }

    @GetMapping("/offresbyentrepriseid/{entrepriseid}")
    public ResponseEntity<List<OffresDto>> getOffresByEntreprise(@PathVariable(value = "entrepriseid") Long entrepriseid) {

        List<Offres> offres = offresRepository.findOffresByEntrepriseId(entrepriseid);
        List<OffresDto>offresDto=offres.stream().map(off->modelMapper.map(off,OffresDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(offresDto, HttpStatus.OK);
    }
    @GetMapping("/offresbyetatandentreprise/{etat}/{entreprise}")
    public ResponseEntity<List<OffresDto>> getOffresByEtatAndEntreprise(@PathVariable(value = "etat") int etat,@PathVariable(value ="entreprise")Long entrepriseid) {

        List<Offres> offres = offresRepository.findOffresByEtatAndEntrepriseId(etat,entrepriseid);
        List<OffresDto>offresDto=offres.stream().map(off->modelMapper.map(off,OffresDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(offresDto, HttpStatus.OK);
    }

}
