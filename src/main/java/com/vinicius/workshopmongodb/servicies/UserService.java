package com.vinicius.workshopmongodb.servicies;

import com.vinicius.workshopmongodb.domain.User;
import com.vinicius.workshopmongodb.dto.UserDTO;
import com.vinicius.workshopmongodb.repository.UserRepository;
import com.vinicius.workshopmongodb.servicies.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        List<User> list = repository.findAll();
        return list;
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));

    }

    public User insert(User obj) {
        return repository.insert(obj);
    }
    public User fromDTO(UserDTO obj){
        return new User(obj.getId(),obj.getName(),obj.getEmail());
    }
}
