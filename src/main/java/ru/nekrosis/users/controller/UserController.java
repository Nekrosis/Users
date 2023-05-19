package ru.nekrosis.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nekrosis.users.model.User;
import ru.nekrosis.users.model.UserDetailsInform;
import ru.nekrosis.users.service.UserService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/")
    public List<User> all() {
        return service.getAll();
    }

    @PostMapping("/")
    public User newUser(@RequestBody User user) {
        return service.save(user);
    }

    @GetMapping("/{id}")
    public Optional<User> info(@PathVariable("id") Long id) {
        return service.info(id);
    }

    @GetMapping("/contact/{id}")
    public UserDetailsInform contactInfo(@PathVariable("id") Long id) {
        return service.contactInfo(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @PutMapping("/")
    public User update(@RequestBody User user) {
        return service.save(user);
    }
}
