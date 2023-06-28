package com.example.demo.controller;

import com.example.demo.model.Price;
import com.example.demo.response.ResponseSuccess;
import com.example.demo.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/price")
public class PriceController {
    private final PriceService priceService;

    public PriceController(PriceService service) {
        priceService = service;
    }

    @GetMapping("/{id}")
    public ResponseSuccess getByID(@PathVariable Long id) {
        Price price = priceService.getByID(id);

        return new ResponseSuccess(HttpStatus.OK.value(), "Success", price);
    }
}
