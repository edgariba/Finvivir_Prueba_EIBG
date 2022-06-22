package com.finvivir.pruebaeibg.Pojos;

import java.math.BigDecimal;

public class Wind {
    public BigDecimal speed;
    public BigDecimal deg;
    public BigDecimal gust;

    public Wind(BigDecimal speed, BigDecimal deg, BigDecimal gust) {
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }
}
