package com.finvivir.pruebaeibg.Dao;

import com.finvivir.pruebaeibg.Entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeatherDao extends JpaRepository<WeatherEntity, Long> {
    Optional<WeatherEntity> findByOpenId(Long idOpen);

    Optional<WeatherEntity> findByName(String name);
}
