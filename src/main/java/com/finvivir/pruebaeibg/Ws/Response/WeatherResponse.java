package com.finvivir.pruebaeibg.Ws.Response;

import com.finvivir.pruebaeibg.Pojos.WeatherData;
import com.finvivir.pruebaeibg.Utils.Header.HeaderResponse;

public class WeatherResponse {
    public HeaderResponse header;
    public WeatherData weather;

    public WeatherResponse(HeaderResponse header, WeatherData weather) {
        this.header = header;
        this.weather = weather;
    }
}
