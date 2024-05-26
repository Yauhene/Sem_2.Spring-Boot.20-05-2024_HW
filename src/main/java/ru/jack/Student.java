package ru.jack;

import com.fasterxml.jackson.annotation.*;
import lombok.*;


@Data
public class Student {
    private static long idCounter = 1L;
    private final long id;
    @Setter
    @Getter
    private String name;
    private String groupName;

    @JsonCreator
    public Student(long id, String name, String groupName) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
    }

    public Student(String name, String groupName) {
        this.id = idCounter++;
        this.name = name;
        this.groupName = groupName;
    }
}
