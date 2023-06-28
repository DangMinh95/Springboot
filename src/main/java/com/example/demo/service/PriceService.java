package com.example.demo.service;

import com.example.demo.model.Price;
import com.example.demo.model.Product;
import com.example.demo.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService implements CrudService<Price> {

    private PriceRepository priceRepository;

    public PriceService(PriceRepository repository) {
        priceRepository = repository;
    }

    @Override
    public List<Price> getAllData() {
        return null;
    }

    @Override
    public Price save(Price data) {
        return null;
    }

    public Price getByID(Long id) {
        return priceRepository.findById(id).orElse(null);
    }
}
