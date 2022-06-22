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
    /**
     * obtener el registro por id de open weather
     * @param idOpen
     * @return
     */
    Optional<WeatherEntity> findByOpenId(Long idOpen);

    /**
     * Obtener el registro del clima por nombre
     * @param name
     * @return
     */
    Optional<WeatherEntity> findByName(String name);

    /**
     * Obtener los registros de clima con un limite
     * @param limit
     * @return
     */
    @Query(value = "SELECT * FROM `t_weather` ORDER BY date_update DESC limit :limit", nativeQuery = true)
    List<WeatherEntity> getLastCities(@Param("limit") int limit);
}
