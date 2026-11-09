package com.rodri.dev.workshopmongo.domain.resources;


import com.rodri.dev.workshopmongo.domain.User;
import com.rodri.dev.workshopmongo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userService.findAll();

        return ResponseEntity.ok().body(list);
    }
}
