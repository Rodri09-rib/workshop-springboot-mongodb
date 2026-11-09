package com.rodri.dev.workshopmongo.service;

import com.rodri.dev.workshopmongo.domain.User;
import com.rodri.dev.workshopmongo.repository.UserRepository;
import com.rodri.dev.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.io.ObjectStreamException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return  userRepository.findAll();
    }

    public User findById(String id) {
       return userRepository.findById(id).orElseThrow(()
               -> new ObjectNotFoundException("User not found"));
    }
}
