package com.finvivir.pruebaeibg.Entity;

import javax.persistence.*;

/**
 * Modelo de datos de la tabla
 * @author Edgar Ivan Barrera
 */
@Entity
@Table(name = "t_wheather")
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
