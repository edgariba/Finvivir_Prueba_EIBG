package com.finvivir.pruebaeibg.Business.Interfaces;

import com.finvivir.pruebaeibg.Ws.Response.WeatherListResponse;
import com.finvivir.pruebaeibg.Ws.Response.WeatherResponse;
import org.springframework.http.ResponseEntity;

public interface WeatherBusiness {
    ResponseEntity<WeatherResponse> consultCity(String city);

    ResponseEntity<WeatherListResponse> getLastTenCities();
}
