package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class ProductService implements CrudService<Product> {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllData() {
        return this.productRepository.findAll();
    }

    @Override
    public Product save(Product data) {
        return this.productRepository.save(data);
    }

    public List<Product> getProductByName(String name){
        return productRepository.getByName(name);
    }

    public Product getByID(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public void deleteByID(Long id){
        productRepository.deleteById(id);
    }
}
