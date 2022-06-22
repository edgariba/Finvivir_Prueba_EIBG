package com.finvivir.pruebaeibg.Business.Impl;

import com.finvivir.pruebaeibg.Business.Interfaces.WeatherBusiness;
import com.finvivir.pruebaeibg.Dao.WeatherDao;
import com.finvivir.pruebaeibg.Entity.WeatherEntity;
import com.finvivir.pruebaeibg.Exceptions.ConflictException;
import com.finvivir.pruebaeibg.Pojos.*;
import com.finvivir.pruebaeibg.Utils.ConstantText;
import com.finvivir.pruebaeibg.Utils.Header.HeaderResponse;
import com.finvivir.pruebaeibg.Ws.Response.WeatherResponse;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("weatherBusinessImpl")
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
public class WeatherBusinessImpl implements WeatherBusiness {

    @Autowired
    private WeatherDao weatherDao;

    @Override
    public ResponseEntity<WeatherResponse> consultCity(String city) {
        String msg;
        WeatherResponse response;
        WeatherEntity save = null;
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(ConstantText.API_WEATHER + city + "&APPID=" + ConstantText.APID_WEATHER)
                .method("GET", null)
                .build();
        Gson gson = new Gson();
        //Verifico la respuesta del endpoint de open weather
        try (Response responseW = client.newCall(request).execute()) {
            String weatherApiResponse = responseW.body().string();
            if (responseW.isSuccessful()) {
                //Convierto el response al objeto
                WeatherGeneral weather = gson.fromJson(weatherApiResponse, WeatherGeneral.class);

                //Verifico si existe registro de ciudad en Mysql
                Optional<WeatherEntity> weatherByIdOpen = weatherDao.findByOpenId(weather.id);
                if (weatherByIdOpen.isPresent()) {
                    //Actualizar registro
                    int numberConsults = weatherByIdOpen.get().getConsults() + 1;
                    WeatherEntity weatherTransform = transformToEntity(weather, numberConsults, weatherByIdOpen.get());
                    weatherTransform.setDateUpdate(new Date());
                    save = weatherDao.save(weatherTransform);
                } else {
                    //Agregar nuevo registro
                    WeatherEntity weatherEntity = new WeatherEntity();
                    WeatherEntity weatherTransform = transformToEntity(weather, 1, weatherEntity);
                    weatherTransform.setDateAdd(new Date());
                    save = weatherDao.save(weatherTransform);
                }

                msg = ConstantText.MSG_GET;
                response = new WeatherResponse(new HeaderResponse(ConstantText.SUCCESS, HttpStatus.OK.value(), msg), transformToJsonResponse(save));
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                JSONObject result = new JSONObject(weatherApiResponse);
                throw new ConflictException(result.get("message").toString());
            }

        } catch (IOException e) {
            //Si el api no esta disponible, busco en la base local el utimo estatus
            throw new RuntimeException(e);
        }

    }

    public WeatherEntity transformToEntity(WeatherGeneral weather, Integer consults, WeatherEntity weatherEntity) {
        weatherEntity.setLon(weather.getCoord().lon);
        weatherEntity.setLat(weather.getCoord().lat);

        for (Weather weatherData : weather.getWeather()) {
            weatherEntity.setId_w(weatherData.id);
            weatherEntity.setMain(weatherData.main);
            weatherEntity.setDescription(weatherData.description);
            weatherEntity.setIcon(weatherData.icon);
        }
        weatherEntity.setBase(weather.getBase());

        weatherEntity.setTemp(weather.getMain().temp);
        weatherEntity.setFeels_like(weather.getMain().feels_like);
        weatherEntity.setTemp_min(weather.getMain().temp_min);
        weatherEntity.setTemp_max(weather.getMain().temp_max);
        weatherEntity.setPressure(weather.getMain().pressure);
        weatherEntity.setHumidity(weather.getMain().humidity);
        weatherEntity.setSea_level(weather.getMain().sea_level);
        weatherEntity.setGrnd_level(weather.getMain().grnd_level);

        weatherEntity.setVisibility(weather.getVisibility());

        weatherEntity.setSpeed(weather.getWind().speed);
        weatherEntity.setDeg(weather.getWind().deg);
        weatherEntity.setGust(weather.getWind().gust);

        weatherEntity.setAll_clouds(weather.getClouds().all);

        weatherEntity.setDt(weather.getDt());

        weatherEntity.setCountry(weather.getSys().country);
        weatherEntity.setSunrise(weather.getSys().sunrise);
        weatherEntity.setSunset(weather.getSys().sunset);

        weatherEntity.setTimezone(weather.getTimezone());
        weatherEntity.setOpenId(weather.getId());

        weatherEntity.setName(weather.getName());
        weatherEntity.setCod(weather.getCod());
        weatherEntity.setConsults(consults);
        return weatherEntity;
    }

    public WeatherData transformToJsonResponse(WeatherEntity weatherEntity) {
        List<Weather> weathers = new ArrayList<>();
        weathers.add(new Weather(weatherEntity.getId_w(), weatherEntity.getMain(), weatherEntity.getDescription(), weatherEntity.getIcon()));
        WeatherData weatherGeneral = new WeatherData(
                new Coord(weatherEntity.getLon(), weatherEntity.getLat()),
                weathers,
                weatherEntity.getBase(),
                new Main(weatherEntity.getTemp(), weatherEntity.getFeels_like(), weatherEntity.getTemp_min(), weatherEntity.getTemp_max(), weatherEntity.getPressure(),
                        weatherEntity.getHumidity(), weatherEntity.getSea_level(), weatherEntity.getGrnd_level()),
                weatherEntity.getVisibility(),
                new Wind(weatherEntity.getSpeed(), weatherEntity.getDeg(), weatherEntity.getGust()),
                new Clouds(weatherEntity.getAll_clouds()),
                weatherEntity.getDt(),
                new Sys(weatherEntity.getCountry(), weatherEntity.getSunrise(), weatherEntity.getSunset()),
                weatherEntity.getTimezone(),
                weatherEntity.getId(),
                weatherEntity.getName(),
                weatherEntity.getCod(),
                weatherEntity.getConsults(),
                weatherEntity.getDateUpdate()
        );
        return weatherGeneral;
    }
}

