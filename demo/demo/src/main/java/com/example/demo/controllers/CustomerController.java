package com.example.demo.controllers;

import com.example.demo.models.Customer;
import com.example.demo.models.Product;
import com.example.demo.repository.CustomerRepos;
import com.example.demo.repository.ReposiveObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Customer")
public class CustomerController {
    @Autowired
    private CustomerRepos customerRepos;

    @GetMapping("/getAll")
    public @ResponseBody
    Iterable<Customer> getAllCustomer(){
        return customerRepos.findAll();
    }

    @GetMapping("/getByIDCustomer/{idCustomer}")
    public @ResponseBody
    ReposiveObject getCustomerByID(@PathVariable Integer idCustomer){
        Optional<Customer> foundCustomer = customerRepos.findById(idCustomer);
        return foundCustomer.isPresent()? new ReposiveObject("oke", "find Customer success", foundCustomer): new ReposiveObject("fail", "can't find customer", "");
    }
    @PutMapping("/update/{idCustomer}")
    public @ResponseBody ResponseEntity<ReposiveObject> update(@RequestBody Customer newCustomer, @PathVariable Integer idCustomer){
        Customer customer = customerRepos.findById(idCustomer).map(
                c->{
                    c.setIdcustomer(newCustomer.getIdcustomer());
                    c.setName(newCustomer.getName());
                    c.setPhonenumber(newCustomer.getPhonenumber());
                    c.setAddress(newCustomer.getAddress());
                    return customerRepos.save(c);
                }
        ).orElseGet(()->{
            return customerRepos.save(newCustomer);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ReposiveObject("oke", "insert success", customer)
        );
    }

    @DeleteMapping("/delete/{idCustomer}")
    public @ResponseBody
    ReposiveObject deleteCustomer(@PathVariable Integer idCustomer) {
        Optional<Customer> foundCustomer = customerRepos.findById(idCustomer);
        if (foundCustomer.isPresent()) {
            customerRepos.deleteById(idCustomer);
            return new ReposiveObject("oke", "delete success", "");
        } else {
            return new ReposiveObject("fail", "delete fail", "");
        }
    }
}
