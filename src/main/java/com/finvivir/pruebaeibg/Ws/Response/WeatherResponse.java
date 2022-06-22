package com.finvivir.pruebaeibg.Ws.Response;

import com.finvivir.pruebaeibg.Pojos.WeatherGeneral;
import com.finvivir.pruebaeibg.Utils.Header.HeaderResponse;

public class WeatherResponse {
    public HeaderResponse header;
    public WeatherGeneral weather;

    public WeatherResponse(HeaderResponse header, WeatherGeneral weather) {
        this.header = header;
        this.weather = weather;
    }
}
