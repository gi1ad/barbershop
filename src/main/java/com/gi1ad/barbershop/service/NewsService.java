package com.gi1ad.barbershop.service;

import com.gi1ad.barbershop.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {

    Page<News> getAll(Pageable pageable);
    News getById(long id);
    News save(News news);
    void remove(long id);
    List<News> findAll();


}
