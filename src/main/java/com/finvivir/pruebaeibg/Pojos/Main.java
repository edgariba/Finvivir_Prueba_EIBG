package com.finvivir.pruebaeibg.Pojos;

import java.math.BigDecimal;

public class Main {
    public BigDecimal temp;
    public BigDecimal feels_like;
    public BigDecimal temp_min;
    public BigDecimal temp_max;
    public BigDecimal pressure;
    public BigDecimal humidity;
    public BigDecimal sea_level;
    public BigDecimal grnd_level;

    public Main(BigDecimal temp, BigDecimal feels_like, BigDecimal temp_min, BigDecimal temp_max, BigDecimal pressure, BigDecimal humidity, BigDecimal sea_level, BigDecimal grnd_level) {
        this.temp = temp;
        this.feels_like = feels_like;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.humidity = humidity;
        this.sea_level = sea_level;
        this.grnd_level = grnd_level;
    }
}
