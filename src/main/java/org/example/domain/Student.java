package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Student {
   // private int student_id;
    private int age;
    private int group_id;
    private int id;
    private String name;
    private String surname;
}
