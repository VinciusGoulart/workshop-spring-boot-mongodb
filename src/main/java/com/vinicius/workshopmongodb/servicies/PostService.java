package com.vinicius.workshopmongodb.servicies;

import com.vinicius.workshopmongodb.domain.Post;
import com.vinicius.workshopmongodb.repository.PostRepository;
import com.vinicius.workshopmongodb.servicies.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));

    }
}
