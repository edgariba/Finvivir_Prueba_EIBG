package com.finvivir.pruebaeibg.Pojos;

public class Weather {
    public Long id;
    public String main;
    public String description;
    public String icon;

    public Weather(Long id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }
}
