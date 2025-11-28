package com.example.ecomproject.controller;

import com.example.ecomproject.model.Product;
import com.example.ecomproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet() {
        return "Hello World";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {

        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        if (service.getProductById(id) != null) {
            return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        Product savedProduct = service.addProduct(product, null);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // @GetMapping("/product/{productId}/image")
    // public ResponseEntity<byte[]> getImageByProductId(@PathVariable int
    // productId){
    // Product product = service.getProductById(productId);
    // // byte[] imageFile = product.getImageDate();

    // return ResponseEntity.ok()
    // .contentType(MediaType.valueOf(product.getImageType()))
    // .body(imageFile);
    // }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {

        Product existingProduct = service.getProductById(id);

        if (existingProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update fields
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setBrand(updatedProduct.getBrand());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setReleaseDate(updatedProduct.getReleaseDate());
        existingProduct.setProductAvailable(updatedProduct.getProductAvailable());
        existingProduct.setStockQuantity(updatedProduct.getStockQuantity());

        Product savedProduct = service.updateProduct(existingProduct);

        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Product product = service.getProductById(id);
        if (product != null) {
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }
}
