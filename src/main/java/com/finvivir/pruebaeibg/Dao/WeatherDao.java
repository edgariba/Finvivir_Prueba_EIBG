package com.finvivir.pruebaeibg.Dao;

import com.finvivir.pruebaeibg.Entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherDao extends JpaRepository<WeatherEntity, Long> {
    Optional<WeatherEntity> findByOpenId(Long idOpen);

    Optional<WeatherEntity> findByName(String name);

    @Query(value = "SELECT * FROM `t_weather` ORDER BY date_update DESC limit :limit", nativeQuery = true)
    List<WeatherEntity> getLastCities(@Param("limit") int limit);
}
