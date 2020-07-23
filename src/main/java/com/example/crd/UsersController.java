package com.example.crd;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class UsersController {

    private final UsersRepository repository;

    public UsersController(UsersRepository repository){
        this.repository = repository;
    }


    @GetMapping("/users")
    public Iterable<Users> getAll(){
        return this.repository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<Users> getById(@PathVariable (value = "id") long id){
        return this.repository.findById(id);
    }

    @PostMapping("/users")
    public Users create(@RequestBody Users users){
        return this.repository.save(users);
    }
}
