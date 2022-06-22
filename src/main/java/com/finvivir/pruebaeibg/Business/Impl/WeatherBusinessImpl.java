package com.finvivir.pruebaeibg.Business.Impl;

import com.finvivir.pruebaeibg.Business.Interfaces.WeatherBusiness;
import com.finvivir.pruebaeibg.Pojos.WeatherGeneral;
import com.finvivir.pruebaeibg.Utils.ConstantText;
import com.finvivir.pruebaeibg.Utils.Header.HeaderResponse;
import com.finvivir.pruebaeibg.Ws.Response.WeatherResponse;
import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service("weatherBusinessImpl")
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.DEFAULT)
public class WeatherBusinessImpl implements WeatherBusiness {

    @Override
    public ResponseEntity<WeatherResponse> consultCity(String city) {
        String msg;
        WeatherResponse response;
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(ConstantText.API_WEATHER + city + "&APPID=" + ConstantText.APID_WEATHER)
                .method("GET", null)
                .build();
        try (Response responseW = client.newCall(request).execute()) {
            //return responseW.body().string();
            String weatherApiResponse = responseW.body().string();
            System.out.println(weatherApiResponse);
            Gson gson = new Gson();
            WeatherGeneral weatherFromJson = gson.fromJson(weatherApiResponse, WeatherGeneral.class);
            msg = ConstantText.MSG_GET;
            response = new WeatherResponse(new HeaderResponse(ConstantText.SUCCESS, HttpStatus.OK.value(), msg), weatherFromJson);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
