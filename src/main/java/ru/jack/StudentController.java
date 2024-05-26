package ru.jack;


import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")

public class StudentController {
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/all")
    public List<Student> getStudents() {
        return repository.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable long id) {
        return repository.getById(id);
    }

    @GetMapping
    public Student getStudentByName(@RequestParam String name) {
        return repository.getByName(name);
    }
}
