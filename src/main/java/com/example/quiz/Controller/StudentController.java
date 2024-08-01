package com.example.quiz.Controller;

import com.example.quiz.Model.Student;
import com.example.quiz.Service.StudentSerivce;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor

public class StudentController {
    private final StudentSerivce studentSerivce;

    @GetMapping("/get")
    public ResponseEntity getStudent() {
        ArrayList<Student> students = studentSerivce.getStudents();
        return ResponseEntity.status(200).body("get students successful");
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors) {
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("error occured: " + message);
        }
        studentSerivce.addStudent(student);
        return ResponseEntity.status(200).body("student added successfully");
    }
    @PutMapping("/update{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @Valid @RequestBody Student student, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("error occured: " + message);

        }
        boolean isUpdated = studentSerivce.updateStudent(id, student);
        if (isUpdated) {
            return ResponseEntity.status(200).body("student updated successfully");
        }
        return ResponseEntity.status(400).body("student not updated successfully");
    }
      @DeleteMapping("/delete{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {

         boolean isDeleted= studentSerivce.deleteStudent(id);
         if (isDeleted) {}
        return ResponseEntity.status(200).body("student deleted successfully");
      }
      @GetMapping("/get")
    public ResponseEntity getStudents(@PathVariable int id) {

        Student student = studentSerivce.getStudentsByName(id);
        if (student != null) {
            return ResponseEntity.status(200).body("get students successful");

        }
        return ResponseEntity.status(400).body("get students failed");

      }
    @GetMapping("/get_m")
    public ResponseEntity getStudentsM() {
        ArrayList<Student> students = studentSerivce.getStudents();
        return ResponseEntity.status(200).body("get students successful");

    }


}
