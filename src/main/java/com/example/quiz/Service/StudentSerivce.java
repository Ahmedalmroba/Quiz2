package com.example.quiz.Service;

import com.example.quiz.Model.Student;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.util.ArrayList;

@Service
public class StudentSerivce {
    ArrayList<Student> students = new ArrayList<Student>();


    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {

        students.add(student);

    }
    public boolean updateStudent(int id, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }
    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }
    public Student getStudentsByName(int id ) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;

            }
        }
        return null;

            }
            public ArrayList<Student> getStudentM(String major){
        ArrayList list = new ArrayList();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getMajor().equals(major)) {
                list.add(students.get(i));
            }
            }
        return list;

            }



    }




