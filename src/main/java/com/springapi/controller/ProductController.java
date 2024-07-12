package com.springapi.controller;

import com.springapi.Service.ProductService;
import com.springapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{prodId}")
    public ResponseEntity<Optional<Product>> getProdById(@PathVariable String prodId){
         return new ResponseEntity<>(productService.getById(prodId), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> add_Product(@RequestPart Product product,
                                              @RequestPart MultipartFile imageFile){
        try{
            Product product1 = productService.addAProduct(product, imageFile);
            return new ResponseEntity<>(product1 , HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("product/{prodId}/image")
    public ResponseEntity<?> getImageByProductId(@PathVariable String prodId){
        Optional<Product> product = productService.getById(prodId);

            if(product.isPresent()){
                byte[] imageFile = product.get().getImageData();

                return ResponseEntity.ok()
                        .contentType(MediaType.valueOf(product.get().getImageType()))
                        .body(imageFile);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.updateProd(product), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/product/{prodId}")
    public void delProduct(@PathVariable String prodId){
            productService.deleteProductByID(prodId);
    }

}
