package com.gi1ad.barbershop.service;

import com.gi1ad.barbershop.entity.Prices;

import java.util.List;

public interface PricesService {

    List<Prices> getAll();
    Prices getById(long id);
    void remove(long id);
    Prices save(Prices prices);
}
