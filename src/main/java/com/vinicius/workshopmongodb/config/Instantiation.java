package com.vinicius.workshopmongodb.config;

import com.vinicius.workshopmongodb.domain.Post;
import com.vinicius.workshopmongodb.domain.User;
import com.vinicius.workshopmongodb.dto.AuthorDTO;
import com.vinicius.workshopmongodb.dto.CommentDTO;
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
        postRepository.deleteAll();

        User mercury = new User(null, "Mercury first", "mercury@gmail.com");
        User venus = new User(null, "Venus second", "venus@gmail.com");
        User earth = new User(null, "Earth third", "earth@gmail.com");

        repository.saveAll(Arrays.asList(mercury, venus, earth));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Hello", "It's hot today!", new AuthorDTO(mercury));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Good morning", "It's a good day!", new AuthorDTO(mercury));

        CommentDTO c1 = new CommentDTO("It's only 170°C", sdf.parse("21/03/2018"), new AuthorDTO(venus));
        CommentDTO c2 = new CommentDTO("Are you burning?", sdf.parse("22/03/2018"), new AuthorDTO(earth));
        CommentDTO c3 = new CommentDTO("It's", sdf.parse("23/03/2018"), new AuthorDTO(earth));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        mercury.getPosts().addAll(Arrays.asList(post1, post2));
        repository.save(mercury);
    }
}
