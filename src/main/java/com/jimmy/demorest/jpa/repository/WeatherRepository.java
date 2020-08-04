package com.jimmy.demorest.jpa.repository;

import com.jimmy.demorest.jpa.data_model.DataModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends CrudRepository<DataModel, Long> {
    @Override
    List<DataModel> findAll();
}
