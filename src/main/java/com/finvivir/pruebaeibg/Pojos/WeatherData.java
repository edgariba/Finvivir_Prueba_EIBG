package com.finvivir.pruebaeibg.Pojos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Clase con los objetos del response de open weather mas los datos de consulta
 */
public class WeatherData {
    public Coord coord;
    public List<Weather> weather;
    public String base;
    public Main main;
    public BigDecimal visibility;
    public Wind wind;
    public Clouds clouds;
    public BigDecimal dt;
    public Sys sys;
    public BigDecimal timezone;
    public Long id;
    public String name;
    public Integer cod;
    public Integer numberConsults;
    public Date dateUpdate;

    public WeatherData(Coord coord, List<Weather> weather, String base, Main main, BigDecimal visibility, Wind wind, Clouds clouds, BigDecimal dt, Sys sys, BigDecimal timezone, Long id, String name, Integer cod, Integer numberConsults, Date dateUpdate) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
        this.numberConsults = numberConsults;
        this.dateUpdate = dateUpdate;
    }
}
