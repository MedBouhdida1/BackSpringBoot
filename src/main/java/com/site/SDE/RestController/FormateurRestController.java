package com.site.SDE.RestController;


import com.site.SDE.Entite.*;
import com.site.SDE.Repository.AdminRepository;
import com.site.SDE.Repository.FormateurRepository;
import com.site.SDE.Service.FormateurService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/formateur")
public class FormateurRestController {
    @Autowired
    private FormateurRepository formateurRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public FormateurService formateurService;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public FormateurRestController(FormateurRepository formateurRepository) {this.formateurRepository= formateurRepository;}



    @PostMapping(path = "login")
    public ResponseEntity<Map<String, Object>> loginformateur(@RequestBody Formateur formateur) {

        HashMap<String, Object> response = new HashMap<>();

        Formateur userFromDB = formateurRepository.findFormateurByEmail(formateur.getEmail());

        if (userFromDB == null) {
            response.put("message", "Admin not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        else {
            Boolean compare = this.bCryptPasswordEncoder.matches(formateur.getMdp(), userFromDB.getMdp());
            if (!compare) {
                response.put("message", "Enseignant not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {
                    String token = Jwts.builder()
                            .claim("data", userFromDB)
                            .signWith(SignatureAlgorithm.HS256, "SECRET")
                            .compact();
                    response.put("token", token);
                    return ResponseEntity.status(HttpStatus.OK).body(response);
                }
            }
        }


    @PostMapping(path = "register")
    public ResponseEntity<?> addformateur(@RequestBody Formateur formateur) {
        if(formateurRepository.existsByEmail(formateur.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        formateur.setMdp(this.bCryptPasswordEncoder.encode(formateur.getMdp()));
        Formateur savedUser = formateurRepository.save(formateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }




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

    @GetMapping("/formateursbyoffreid/{offreid}")
    public ResponseEntity<List<Formateur>> getAllformateurByOffreId(@PathVariable(value = "offreid") Long offreId) {

        List<Formateur> formateurs = formateurRepository.findFormateursByOffreId(offreId);
        return new ResponseEntity<>(formateurs, HttpStatus.OK);
    }


}
