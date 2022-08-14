package com.site.SDE.Service;

import com.site.SDE.Entite.Contact;
import com.site.SDE.Repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContactServiceImpl implements ContactService{

    @Autowired
    ContactRepository contactRepository;


    @Override
    public List<Contact> listContact() {
        return contactRepository.findAll();
    }

    @Override
    public Contact ajouterContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> GetContactById(Long id) {
        return contactRepository.findById(id);
    }

    @Override
    public void supprimerById(Long id) {
        contactRepository.deleteById(id);
    }
}
