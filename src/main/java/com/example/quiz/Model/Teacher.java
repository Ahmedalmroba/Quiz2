package com.example.quiz.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @Size(min = 5, max = 20)
    @NotNull(message = "should not be null")
    private int id;
    @Size(min = 5, max = 20)
    @NotEmpty(message = "should not be empty")
    private String Name;
    @Positive
    @Size(min = 5, max = 20)
    @NotEmpty(message = "should not be empty")
    private String salary;

}
