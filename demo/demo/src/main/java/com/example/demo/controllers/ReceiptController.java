package com.example.demo.controllers;

import com.example.demo.models.Receipt;
import com.example.demo.models.Staff;
import com.example.demo.repository.ReceiptRepos;
import com.example.demo.repository.ReposiveObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Receipt")
public class ReceiptController {
    @Autowired
    private ReceiptRepos receiptRepos;

    @GetMapping("/getAll")
    public @ResponseBody
    Iterable<Receipt> getAllReceipt() {
        return receiptRepos.findAll();
    }

    @GetMapping("/getByIDStaff/{idReceipt}")
    public @ResponseBody
    ReposiveObject getReceiptByID(@PathVariable Integer idReceipt) {
        Optional<Receipt> foundReceipt = receiptRepos.findById(idReceipt);
        return foundReceipt.isPresent() ?
                new ReposiveObject("oke", "success", foundReceipt) : new ReposiveObject("fail", "can't find", "");
    }

    @PutMapping("/insert")
    public @ResponseBody ResponseEntity<ReposiveObject> insertReceipt(@RequestBody Receipt newReceipt){
        receiptRepos.save(newReceipt);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ReposiveObject("oke", "insert success", newReceipt)
        );
    }

    @DeleteMapping("/delete/{idReceipt}")
    public @ResponseBody
    ReposiveObject deleteReceipt(@PathVariable Integer idReceipt) {
        Optional<Receipt> foundReceipt = receiptRepos.findById(idReceipt);
        if (foundReceipt.isPresent()) {
            receiptRepos.deleteById(idReceipt);
            return new ReposiveObject("oke", "delete success", "");
        } else {
            return new ReposiveObject("fail", "delete fail", "");
        }
    }
}
