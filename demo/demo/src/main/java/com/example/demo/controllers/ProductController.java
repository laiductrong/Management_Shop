package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepos;
import com.example.demo.repository.ReposiveObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Product")
public class ProductController {
    @Autowired
    private ProductRepos productRepos;

    @GetMapping("/getAll")
    public @ResponseBody
    Iterable<Product> getAllProduct() {
        return productRepos.findAll();
    }

    @GetMapping("/getByIDProduct/{idProduct}")
    public @ResponseBody
    ReposiveObject getProductByID(@PathVariable String idProduct) {
        Optional<Product> foundProduct = productRepos.findById(idProduct);
        return foundProduct.isPresent() ? new ReposiveObject("oke", "success", foundProduct) : new ReposiveObject("fail", "can't find product", "");
    }

    @GetMapping("/getByIDCategory/{idCategory}")
    public @ResponseBody
    ReposiveObject getProductByCategory(@PathVariable String idCategory) {
        List<Product> foundProduct = productRepos.findByIdcategory(idCategory);
        return foundProduct.size() > 0 ? new ReposiveObject("oke", "success", foundProduct) : new ReposiveObject("fail", "can't find product", "");
    }

    @PutMapping("/update/{idProduct}")
    public @ResponseBody
    ResponseEntity<ReposiveObject> update(@RequestBody Product newProduct, @PathVariable String idProduct) {
        Product product = productRepos.findById(idProduct).map(
                p -> {
//                    p.setIdproduct(newProduct.getIdproduct());
                    p.setIdcategory(newProduct.getIdcategory());
                    p.setPrice(newProduct.getPrice());
                    p.setInfor(newProduct.getInfor());
                    return productRepos.save(p);
                }
        ).orElseGet(() -> {
            return productRepos.save(newProduct);
        });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ReposiveObject("oke", "insert success", product)
        );
    }

    @DeleteMapping("/delete/{idProduct}")
    public @ResponseBody
    ReposiveObject delete(@PathVariable String idProduct) {
        Optional<Product> foundProduct = productRepos.findById(idProduct);
        if (foundProduct.isPresent()) {
            productRepos.deleteById(idProduct);
            return new ReposiveObject("oke", "delete success", "");
        } else {
            return new ReposiveObject("fail", "delete fail", "");
        }
    }

}
