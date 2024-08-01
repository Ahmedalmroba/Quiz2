package com.example.quiz.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Student {
    @Size(min = 5, max = 20)
    @NotNull(message = "should not be null")
    private int id;
    @Size(min = 5, max = 20)
    @NotEmpty(message = "should not be empty")
    private String Name;
    @Size(min = 5, max = 20)
    @NotEmpty(message = "should not be empty")
    private String age;
    @Size(min = 5, max = 20)
    @NotEmpty(message = "should not be empty")
    private String major ;
}
