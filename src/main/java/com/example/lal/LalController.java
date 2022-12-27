package com.example.lal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LalController {

    @Autowired
    private LalRepository repository;

    @PostMapping("lal")
    public Lal create(@RequestBody Lal entity) {
        System.out.println(entity.getName());
        return repository.save(entity);
    }

    @GetMapping("lal")
    public Iterable<Lal> get() {
        return repository.findAll();
    }
}
