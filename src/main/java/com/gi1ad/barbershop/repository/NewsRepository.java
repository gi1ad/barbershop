package com.gi1ad.barbershop.repository;

import com.gi1ad.barbershop.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Long> {
}
