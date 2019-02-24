package com.gi1ad.barbershop.service;

import com.gi1ad.barbershop.entity.News;
import com.gi1ad.barbershop.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService  {

    @Autowired
    private NewsRepository repository;


    public List<News> findAll() {
        return repository.findAll();
    }

    public Page<News> getAll(Pageable pageable) {
        return repository.findAll(pageable);
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
