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
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
    }

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public User update(User obj) {
        User newObj = userRepository.findById(obj.getId())
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public void delete(String id) {
        userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found"));
        userRepository.deleteById(id);
    }

    public User fromDto(UserDto objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
