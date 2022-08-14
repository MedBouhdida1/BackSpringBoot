package com.site.SDE.Service;

import com.site.SDE.Entite.Offres;
import com.site.SDE.Repository.OffresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffresServiceImpl implements OffresService{

    @Autowired
    OffresRepository offresRepository;

    @Override
    public Offres ajouterOffre(Offres offre) {
        return offresRepository.save(offre);
    }

    @Override
    public Offres modifierOffre(Offres offre) {
        return offresRepository.save(offre);
    }

    @Override
    public List<Offres> lstOffres() {
        return offresRepository.findAll();
    }

    @Override
    public Optional<Offres> getOffreById(Long id) {
        return offresRepository.findById(id);
    }

    @Override
    public List<Offres> getOffreByEtat(int etat) {
        return offresRepository.findByEtat(etat);
    }

    @Override
    public void supprimerOffre(Long id) {
        offresRepository.deleteById(id);

    }
}
