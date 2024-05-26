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
        return (Student) students.stream()
                .filter(it -> Objects.equals(it.getName(), name))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getStudentByGroupName(String groupName) {
        List<Student> groupList = new ArrayList<>();

        for (Student st: students) {
            if (st.getGroupName().equals(groupName)) {
                groupList.add(st);
            }
        }
        return groupList;
    }
    public List<Student> getStudentByNameLike(String nameLike) {
        List<Student> namesList = new ArrayList<>();

        for (Student st: students   ) {
            System.out.println(st.getName());
            if (st.getName().contains(nameLike)) {
                namesList.add(st);
            }
        }
        return namesList;
    }

    public Student addStudent(Student student) {
       students.add(student);
        return student;
    }
}
