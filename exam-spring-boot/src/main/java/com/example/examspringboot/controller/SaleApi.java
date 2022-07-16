package com.example.examspringboot.controller;

import com.example.examspringboot.entity.Product;
import com.example.examspringboot.entity.Sale;
import com.example.examspringboot.repository.ProductRepository;
import com.example.examspringboot.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

public class SaleApi {
    @Autowired
    private SaleRepository saleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Sale> findAll(){
        return saleRepository.findAll();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Sale findById(@PathVariable Integer siNo) {
        Optional<Sale> optionalSale = saleRepository.findById(siNo);
        if(optionalSale.isPresent()){
            return optionalSale.get();
        }
        return null;
    }
}
