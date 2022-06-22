package com.finvivir.pruebaeibg.Pojos;

import java.math.BigDecimal;

public class Sys {
    public String country;
    public BigDecimal sunrise;
    public BigDecimal sunset;

    public Sys(String country, BigDecimal sunrise, BigDecimal sunset) {
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }
}
