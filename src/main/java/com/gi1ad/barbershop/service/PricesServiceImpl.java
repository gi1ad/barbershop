package com.gi1ad.barbershop.service;

import com.gi1ad.barbershop.entity.Prices;
import com.gi1ad.barbershop.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {

    @Autowired
    PricesRepository repository;


    public List<Prices> getAll() {
        return repository.findAll();
    }


    public Prices getById(long id) {
        return repository.getOne(id);
    }


    public void remove(long id) {

    }

    public Prices save(Prices prices) {
        return repository.save(prices);
    }
}
