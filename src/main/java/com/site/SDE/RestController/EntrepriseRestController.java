package com.site.SDE.RestController;


import com.site.SDE.Entite.Entreprise;
import com.site.SDE.Repository.EntrepriseRepository;
import com.site.SDE.Service.EntrepriseService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/entreprise")
public class EntrepriseRestController {

    @Autowired
    EntrepriseService entrepriseService;
    private EntrepriseRepository entrepriseRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public EntrepriseRestController(EntrepriseRepository entrepriseRepository) {this.entrepriseRepository= entrepriseRepository;}


    @PostMapping(path = "login")
    public ResponseEntity<Map<String, Object>> loginentreprise(@RequestBody Entreprise entreprise) {

        HashMap<String, Object> response = new HashMap<>();

        Entreprise userFromDB = entrepriseRepository.findEntrepriseByEmail(entreprise.getEmail());

        if (userFromDB == null) {
            response.put("message", "Admin not found !");
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

    @PostMapping(path = "register")
    public ResponseEntity<?> addentreprise(@RequestBody Entreprise entreprise) {
        if(entrepriseRepository.existsByEmail(entreprise.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        entreprise.setMdp(this.bCryptPasswordEncoder.encode(entreprise.getMdp()));
        Entreprise savedUser = entrepriseRepository.save(entreprise);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

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
