package com.finvivir.pruebaeibg.Entity;

import javax.persistence.*;

/**
 * Modelo de datos de la tabla
 *
 * @author Edgar Ivan Barrera
 */
@Entity
@Table(name = "t_weather")
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lon")
    private Float lon;

    @Column(name = "lat")
    private Float lat;

    @Column(name = "id_w")
    private Long id_w;

    @Column(name = "main")
    private String main;

    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private String icon;

    @Column(name = "base")
    private String base;

    @Column(name = "temp")
    private Float temp;

    @Column(name = "feels_like")
    private Float feels_like;

    @Column(name = "temp_min")
    private Float temp_min;

    @Column(name = "temp_max")
    private Float temp_max;

    @Column(name = "pressure")
    private Float pressure;

    @Column(name = "humidity")
    private Float humidity;

    @Column(name = "sea_level")
    private Float sea_level;

    @Column(name = "grnd_level")
    private Float grnd_level;

    @Column(name = "visibility")
    private Float visibility;

    @Column(name = "speed")
    private Float speed;

    @Column(name = "deg")
    private Float deg;

    @Column(name = "gust")
    private Float gust;

    @Column(name = "all_clouds")
    private Float all_clouds;

    @Column(name = "dt")
    private Float dt;

    @Column(name = "country")
    private String country;

    @Column(name = "sunrise")
    private Float sunrise;

    @Column(name = "sunset")
    private Float sunset;

    @Column(name = "timezone")
    private Float timezone;

    @Column(name = "id_open", unique = true)
    private Float id_open;

    @Column(name = "name")
    private String name;

    @Column(name = "cod")
    private Float cod;

    @Column(name = "consults")
    private Integer consults;
}
