package com.site.SDE.RestController;

import com.site.SDE.Entite.Contact;
import com.site.SDE.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping(value = "/contact")
public class ContactRestController {


    @Autowired
    ContactService contactService;


    @RequestMapping(method = RequestMethod.POST)
    public Contact ajouterContact(@RequestBody Contact contact){
        return contactService.ajouterContact(contact);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<Contact> GetContactById(@PathVariable("id")Long id){
        Optional<Contact>contact=contactService.GetContactById(id);
        return contact;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void suprrimerContact(@PathVariable("id")Long id){
        contactService.supprimerById(id);
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Contact> listContact(){
        return contactService.listContact();
    }
}
