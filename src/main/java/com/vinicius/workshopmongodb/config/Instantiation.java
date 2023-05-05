package com.vinicius.workshopmongodb.config;

import com.vinicius.workshopmongodb.domain.User;
import com.vinicius.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        User mercury = new User(null, "Mercury first", "mercury@gmail.com");
        User venus = new User(null, "Venus second", "venus@gmail.com");
        User earth = new User(null, "Earth third", "earth@gmail.com");

        repository.saveAll(Arrays.asList(mercury, venus, earth));
    }
}
