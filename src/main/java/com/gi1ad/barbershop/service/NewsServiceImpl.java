package com.gi1ad.barbershop.service;

import com.gi1ad.barbershop.entity.News;
import com.gi1ad.barbershop.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService  {

    @Autowired
    private NewsRepository repository;



    public List<News> getAll() {
        return repository.findAll();
    }

    public News getById(long id) {
        return repository.getOne(id);
    }


    public News save(News news) {
        return repository.saveAndFlush(news);
    }


    public void remove(long id) {
        repository.deleteById(id);

    }
}
