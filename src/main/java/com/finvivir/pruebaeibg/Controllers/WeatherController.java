package com.finvivir.pruebaeibg.Controllers;

import com.finvivir.pruebaeibg.Business.Interfaces.WeatherBusiness;
import com.finvivir.pruebaeibg.Exceptions.ConflictException;
import com.finvivir.pruebaeibg.Utils.ConstantText;
import com.finvivir.pruebaeibg.Utils.Header.HeaderResponse;
import com.finvivir.pruebaeibg.Ws.Response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * * @author Edgar Ivan Barrera
 * Clase controller WeatherController
 */

@CrossOrigin
@RestController
@RequestMapping(ConstantText.API_V1 + "weather/")
public class WeatherController {

    @Autowired
    private WeatherBusiness weatherBusiness;

    /**
     * Obtener los resultados del clima
     *
     * @return
     */
    @GetMapping(value = "/getByCity/{city}")
    public ResponseEntity<WeatherResponse> getWeatherByCity(@PathVariable String city) {
        WeatherResponse response;
        String msg;
        try {
            return weatherBusiness.consultCity(city);
        } catch (ConflictException e) {
            msg = e.getMessage();
            response = new WeatherResponse(new HeaderResponse(ConstantText.CONFLICT, HttpStatus.CONFLICT.value(), msg), null);
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } catch (Exception e) {
            msg = e.getMessage();
            response = new WeatherResponse(new HeaderResponse(ConstantText.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), msg), null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
