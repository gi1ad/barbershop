package com.gi1ad.barbershop.service;

import com.gi1ad.barbershop.entity.News;

import java.util.List;

public interface NewsService {

    List<News> getAll();
    News getById(long id);
    News save(News news);
    void remove(long id);


}
