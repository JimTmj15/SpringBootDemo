package com.jimmy.demorest.weather;

import com.jimmy.demorest.exception.NoCityFoundException;
import com.jimmy.demorest.jpa.data_model.DataModel;
import com.jimmy.demorest.jpa.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private WeatherRepository weatherRepo;

    @GetMapping("getCitiesWeather")
    List<DataModel> getCitiesWeather() {
        return weatherRepo.findAll();
    }

    @GetMapping("/getCityWeather/{id}")
    DataModel getCityWeather(@PathVariable Long id)  {
        return weatherRepo.findById(id).orElseThrow(() -> new NoCityFoundException(id));
    }

    @PostMapping("/recordCityWeather")
    DataModel newCityWeather(@Valid @RequestBody DataModel cityWeather) {
        return weatherRepo.save(cityWeather);
    }


}
