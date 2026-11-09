package com.rodri.dev.workshopmongo.service;

import com.rodri.dev.workshopmongo.domain.User;
import com.rodri.dev.workshopmongo.dto.UserDto;
import com.rodri.dev.workshopmongo.repository.UserRepository;
import com.rodri.dev.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

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

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public User fromDto(UserDto objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

    public void delete(String id) {
        userRepository.findById(id).orElseThrow(()
                -> new ObjectNotFoundException("User not found"));
        userRepository.deleteById(id);
    }
}
