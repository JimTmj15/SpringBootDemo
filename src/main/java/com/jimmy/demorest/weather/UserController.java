package com.jimmy.demorest.weather;

import com.jimmy.demorest.exception.NoUserFoundException;
import com.jimmy.demorest.jpa.data_model.UserDataModel;
import com.jimmy.demorest.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("getUsers")
    List<UserDataModel> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/getUser/{id}")
    UserDataModel getUser(@PathVariable Long id) {
        return userRepo.findById(id).orElseThrow(() -> new NoUserFoundException(id));
    }

    @PostMapping("/registerUser")
    UserDataModel registerUser(@Valid @RequestBody UserDataModel userData) {
        return userRepo.save(userData);
    }
}
