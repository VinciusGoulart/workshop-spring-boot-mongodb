package com.vinicius.workshopmongodb.config;

import com.vinicius.workshopmongodb.domain.Post;
import com.vinicius.workshopmongodb.domain.User;
import com.vinicius.workshopmongodb.repository.PostRepository;
import com.vinicius.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repository.deleteAll();

        User mercury = new User(null, "Mercury first", "mercury@gmail.com");
        User venus = new User(null, "Venus second", "venus@gmail.com");
        User earth = new User(null, "Earth third", "earth@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Hello", "It's hot today!", mercury);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Good morning", "It's a good day!", venus);

        repository.saveAll(Arrays.asList(mercury, venus, earth));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
