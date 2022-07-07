package com.site.SDE.RestController;


import com.site.SDE.Entite.Admin;
import com.site.SDE.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping (value = "/admin")
public class AdminRestController {
    @Autowired
    AdminService adminService;

    @RequestMapping(method = RequestMethod.POST)
    public Admin ajouterAdmin(@RequestBody Admin admin){
        return adminService.ajouterAdmin(admin);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Admin modifierAdmin(@PathVariable("id")Long id,@RequestBody Admin admin){
        Admin newAdmin=adminService.modifierAdmin(admin);
        return newAdmin;
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<Admin>GetAdminById(@PathVariable("id")Long id){
        Optional<Admin>admin=adminService.GetAdminById(id);
        return admin;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void suprrimerAdmin(@PathVariable("id")Long id){
        adminService.supprimerById(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Admin>listAdmin(){
        return adminService.listAdmin();
    }


}
