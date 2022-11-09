package com.example.demo.controllers;

import com.example.demo.models.Detailreceipt;
import com.example.demo.models.Staff;
import com.example.demo.repository.DetailReceiptRepos;
import com.example.demo.repository.ReposiveObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Detail")
public class DetailReceiptController {
    @Autowired
    private DetailReceiptRepos detailReceiptRepos;

    @GetMapping("/getAll")
    public @ResponseBody
    Iterable<Detailreceipt> getDetail(){
        return detailReceiptRepos.findAll();
    }

    @GetMapping("/getByID/{idDetail}")
    public @ResponseBody
    ReposiveObject getDetailByID(@PathVariable Integer idDetail){
        Optional<Detailreceipt> foundDetail = detailReceiptRepos.findById(idDetail);
        return foundDetail.isPresent()?
                new ReposiveObject("oke", "find success", foundDetail): new ReposiveObject("fail","find fail", "");
    }

    @PutMapping("/insertDetail")
    public @ResponseBody
    ResponseEntity<ReposiveObject> insertDetail(@RequestBody Detailreceipt detailreceipt){
        detailReceiptRepos.save(detailreceipt);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ReposiveObject("oke", "insert success", detailreceipt)
        );
    }

    @DeleteMapping("/delete/{idDetail}")
    public @ResponseBody
    ReposiveObject deleteCustomer(@PathVariable Integer idDetail) {
        Optional<Detailreceipt> foundDetail = detailReceiptRepos.findById(idDetail);
        if (foundDetail.isPresent()) {
            detailReceiptRepos.deleteById(idDetail);
            return new ReposiveObject("oke", "delete success", "");
        } else {
            return new ReposiveObject("fail", "delete fail", "");
        }
    }
}
