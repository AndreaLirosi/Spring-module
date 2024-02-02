package com.example.testCRUD;

import com.example.testCRUD.Services.StudentService;
import com.example.testCRUD.entities.Student;
import com.example.testCRUD.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void checkStudentService() throws Exception {
        Student student = new Student();
        student.setWorking(true);
        student.setName("Andrea");
        student.setSurname("Rossi");

        Student studentFromDb = studentRepository.save(student);
        assertThat(studentFromDb.getId()).isNotNull();

        Student studentFromService = studentService.changeWorkingStatus(student.getId(),true);
        assertThat(studentFromService.getId()).isNotNull();
        assertThat(studentFromService.isWorking()).isTrue();

        Student studentByFind = studentRepository.findById(studentFromDb.getId()).get();
        assertThat(studentByFind).isNotNull();
        assertThat(studentByFind.getId()).isNotNull();
        assertThat(studentByFind.getId()).isEqualTo(studentFromDb.getId());
        assertThat(studentByFind.isWorking()).isTrue();
    }
}
