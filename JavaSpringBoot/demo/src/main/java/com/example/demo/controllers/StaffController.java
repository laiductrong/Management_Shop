package com.example.demo.controllers;

import com.example.demo.models.Customer;
import com.example.demo.models.Staff;
import com.example.demo.repository.ReposiveObject;
import com.example.demo.repository.StaffRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Staff")
public class StaffController {
    @Autowired
    private StaffRepos staffRepos;

    @GetMapping("/getAll")
    public @ResponseBody
    Iterable<Staff> getAllStaff() {
        return staffRepos.findAll();
    }

    @GetMapping("/getByIDStaff/{idStaff}")
    public @ResponseBody
    ReposiveObject getStaffByID(@PathVariable Integer idStaff) {
        Optional<Staff> foundStaff = staffRepos.findById(idStaff);
        return foundStaff.isPresent() ?
                new ReposiveObject("oke", "success", foundStaff) : new ReposiveObject("fail", "find staff fail", "");
    }

    @PutMapping("/insertStaff")
    public @ResponseBody
    ResponseEntity<ReposiveObject> insertStaff(@RequestBody Staff newStaff){
        staffRepos.save(newStaff);
         return ResponseEntity.status(HttpStatus.OK).body(
                new ReposiveObject("oke", "insert success", newStaff)
        );
    }

    @DeleteMapping("/delete/{idStaff}")
    public @ResponseBody
    ReposiveObject deleteCustomer(@PathVariable Integer idStaff) {
        Optional<Staff> foundStaff = staffRepos.findById(idStaff);
        if (foundStaff.isPresent()) {
            staffRepos.deleteById(idStaff);
            return new ReposiveObject("oke", "delete success", "");
        } else {
            return new ReposiveObject("fail", "delete fail", "");
        }
    }

}
