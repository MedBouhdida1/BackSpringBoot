package com.site.SDE.Service;


import com.site.SDE.Entite.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> listContact();
    Contact ajouterContact(Contact contact);
    Optional<Contact> GetContactById(Long id);
    void supprimerById(Long id);

}
