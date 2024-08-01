package com.example.quiz.Controller;

import com.example.quiz.Model.Teacher;
import com.example.quiz.Service.TeacherSerivce;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherSerivce teacherSerivce;

    @GetMapping("get")
    public ResponseEntity getAllTeachers() {
        ArrayList<Teacher> teachers = teacherSerivce.getTeachers();
        return ResponseEntity.status(200).body("getAllTeachers()");
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("error occured: " + message);

        }
        teacherSerivce.addTeacher(teacher);
        return ResponseEntity.status(200).body("addTeacher()");
    }

    @PutMapping("/update{id}")
    public ResponseEntity updateTeacher(@PathVariable int id, @Valid @RequestBody Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("error occured: " + message);
        }
        boolean isUpdated = teacherSerivce.updateTeacher(id, teacher);
        if (isUpdated) {
            return ResponseEntity.status(200).body("isUpdated: ");

        }
        return ResponseEntity.status(400).body("is not Updated: ");

    }
    @DeleteMapping("/delete{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id) {
        boolean isDeleted = teacherSerivce.deleteTeacher(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("isDeleted: ");
        }
        return ResponseEntity.status(400).body("is not Deleted: ");
    }
    @GetMapping("/get")
    public ResponseEntity getTeacher(@PathVariable int id) {
        Teacher teacher = teacherSerivce.getTeacher(id);
        if (teacher != null) {
            return ResponseEntity.status(200).body(teacher);

        }
        return ResponseEntity.status(400).body("is not Found: ");

    }
}