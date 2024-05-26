package ru.jack;


import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")

public class StudentController {
    private final StudentRepository repository;

    @Autowired
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

    /**
     * Метод поиска студента по имени
     * образец запроса - http://localhost:8280/students?name=Ivan%20Morkovkin
     * @param name
     * @return
     */
    @GetMapping
    public Student getStudentByName(@RequestParam String name) {
        return repository.getByName(name);
    }

    /**
     * Метод поиска студентов по имени группы
     * образец запроса - http://localhost:8280/students/group/Tester
     * @param groupName - имя группы
     * @return - результат
     */
    @GetMapping("group/{groupName}")
    public List<Student> getStudentByGroupName(@PathVariable String groupName) {
        return repository.getStudentByGroupName(groupName);
    }

    /**
     * Метод поиска студента по фрагменту имени
     * образец запроса - http://localhost:8280/students/name/Ivan
     * @param nameLike
     * @return
     */
    @GetMapping("/name/{nameLike}")
    public List<Student> getStudentByNameLike(@PathVariable String nameLike) {
        System.out.println("Enter in getStudentByNameLike");
        return repository.getStudentByNameLike(nameLike);
    }
}
