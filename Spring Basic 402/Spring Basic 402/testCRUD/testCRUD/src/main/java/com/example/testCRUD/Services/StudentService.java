package com.example.testCRUD.Services;

import com.example.testCRUD.entities.Student;
import com.example.testCRUD.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student changeWorkingStatus(Long studentId, boolean isWorking) {
        Optional<Student> student = studentRepository.findById(studentId);

        if (!student.isPresent()) return null;

        student.get().setWorking(isWorking);
        return studentRepository.save(student.get());
    }
}
