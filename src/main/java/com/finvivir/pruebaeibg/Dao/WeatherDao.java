package com.finvivir.pruebaeibg.Dao;

import com.finvivir.pruebaeibg.Entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDao extends JpaRepository<WeatherEntity, Long> {
}
