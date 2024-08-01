package com.example.quiz.Service;

import com.example.quiz.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherSerivce {
    ArrayList teachers = new ArrayList();


    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);

    }
    public boolean updateTeacher( int id,Teacher teacher) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).equals(teacher)) {
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }
    public boolean deleteTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).equals(id)) {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }
    public Teacher getTeacher(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).equals(id)) {
                return (Teacher) teachers.get(i);
            }
        }
        return null;
    }
}

