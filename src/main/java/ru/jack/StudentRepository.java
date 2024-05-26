package ru.jack;

import org.springframework.stereotype.*;

import java.util.*;

@Component
public class StudentRepository {

    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        students.add(new Student("Karl Marx","Developer"));
        students.add(new Student("Otto von Bismarck","Developer"));
        students.add(new Student("Louis Renault","Developer"));
        students.add(new Student("Ivan Morkovkin","Developer"));
        students.add(new Student("Semen Ivanov","Tester"));
        students.add(new Student("Ivan Semenov","Tester"));
        students.add(new Student("Damon Hill","Tester"));
        students.add(new Student("Oleg Pirogov","Tester"));
    }
    public List<Student> getAll() {
        return List.copyOf(students);
    }

    public Student getById(long id) {
        return students.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public Student getByName(String name) {
        return students.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .findFirst()
                .orElse(null);
    }

    public Student getByGroupName(String groupName) {
        return students.stream()
                .filter(it -> Objects.equals(it.getGroupName(), groupName))
                .findFirst()
                .orElse(null);
    }
}
