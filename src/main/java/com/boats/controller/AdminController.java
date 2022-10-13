package com.boats.controller;

import com.boats.model.AdminModel;
import com.boats.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<AdminModel> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public Optional<AdminModel> getAdmin(@PathVariable ("id") Integer id){
        return adminService.getAdmin(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminModel saveAdmin(@RequestBody AdminModel adminModel){
        return adminService.saveAdmin(adminModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAdmin(@PathVariable ("id") Integer id){
        return adminService.deleteAdmin(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public AdminModel updateAdmin(@RequestBody AdminModel adminModel){
        return adminService.updateAdmin(adminModel);
    }
}
