package com.finvivir.pruebaeibg.Ws.Response;

import com.finvivir.pruebaeibg.Pojos.WeatherData;
import com.finvivir.pruebaeibg.Utils.Header.HeaderResponse;

import java.util.List;

public class WeatherListResponse {
    public HeaderResponse header;
    public List<WeatherData> weatherList;

    /**
     * Constructor para la lista de ciudades
     *
     * @param header
     * @param weatherList
     */
    public WeatherListResponse(HeaderResponse header, List<WeatherData> weatherList) {
        this.header = header;
        this.weatherList = weatherList;
    }
}
