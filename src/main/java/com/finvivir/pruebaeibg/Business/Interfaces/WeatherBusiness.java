package com.finvivir.pruebaeibg.Business.Interfaces;

import com.finvivir.pruebaeibg.Ws.Response.WeatherListResponse;
import com.finvivir.pruebaeibg.Ws.Response.WeatherResponse;
import org.springframework.http.ResponseEntity;

public interface WeatherBusiness {
    /**
     *Método para obtener los datos de clima por ciudad
     * @param city
     * @return
     */
    ResponseEntity<WeatherResponse> consultCity(String city);

    /**
     * Método para consultar las ultimas 10 ciudades
     * @return
     */
    ResponseEntity<WeatherListResponse> getLastTenCities();
}
