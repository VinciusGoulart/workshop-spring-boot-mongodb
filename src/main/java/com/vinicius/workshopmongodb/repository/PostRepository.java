package com.vinicius.workshopmongodb.repository;

import com.vinicius.workshopmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    public List<Post> findByTitle(String text);
    public List<Post> findByTitleContainingIgnoreCase(String text);
}
