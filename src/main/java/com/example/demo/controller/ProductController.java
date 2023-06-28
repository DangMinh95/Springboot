package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.response.ResponseSuccess;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
@NoArgsConstructor
public class ProductController {
    private ProductService productService;

    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseSuccess getAllProduct() {
        List<Product> listProduct = this.productService.getAllData();
        int size = listProduct.size();

        return new ResponseSuccess(HttpStatus.OK.value(), "Success", size, listProduct);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseSuccess createProduct(@Valid @RequestBody Product product) {
        product.setCreateAt(new Date());
        Product product1 = this.productService.save(product);

        return new ResponseSuccess(HttpStatus.CREATED.value(), "Insert success", product1);
    }

    @GetMapping("/name/{name}")
    public ResponseSuccess getProductByName(@PathVariable String name) {
        List<Product> productList = productService.getProductByName(name);

        return new ResponseSuccess(HttpStatus.OK.value(), "Success", productList);
    }

    @GetMapping("/{id}")
    public ResponseSuccess getByID(@PathVariable Long id){
        Product product = productService.getByID(id);

        return new ResponseSuccess(HttpStatus.OK.value(), "Success", product);
    }

    @DeleteMapping("/{id}")
    public ResponseSuccess deleteByID(@PathVariable Long id){
        productService.deleteByID(id);

        return new ResponseSuccess(HttpStatus.OK.value(), "Success", null);
    }
}
