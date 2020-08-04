package com.jimmy.demorest.jpa.repository;

import com.jimmy.demorest.jpa.data_model.DataModel;
import com.jimmy.demorest.jpa.data_model.UserDataModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserDataModel, Long> {
    @Override
    List<UserDataModel> findAll();
}
