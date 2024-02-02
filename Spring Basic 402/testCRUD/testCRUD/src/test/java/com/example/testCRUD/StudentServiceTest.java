package com.example.testCRUD;

import com.example.testCRUD.Services.StudentService;
import com.example.testCRUD.entities.Student;
import com.example.testCRUD.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        /* creiamo uno studente da zero */
        Student student = new Student();
        student.setWorking(false);
        student.setName("Andrea");
        student.setSurname("Rossi");
        /* e viene poi salvato nella repository, e viene verificato che l'id non sia nullo */
        Student studentFromDb = studentRepository.save(student);
        assertThat(studentFromDb.getId()).isNotNull();
        /* viene chiamato il metodo changeWorkingStatus e si verifica che l'id non isa nullo e che lo stato di isWorking sia true */
        Student studentFromService = studentService.changeWorkingStatus(student.getId(),true);
        assertThat(studentFromService.getId()).isNotNull();
        assertThat(studentFromService.isWorking()).isTrue();

        Student studentByFind = studentRepository.findById(studentFromDb.getId()).get();
        assertThat(studentByFind).isNotNull();
        assertThat(studentByFind.getId()).isNotNull();
        assertThat(studentByFind.getId()).isEqualTo(studentFromDb.getId());
        assertThat(studentByFind.isWorking()).isTrue();
    }

    @Test
    public void updateStudentEmploymentStatusInvalidID() {
        Optional<Student> result = Optional.ofNullable(studentService.changeWorkingStatus(2L, true));
        assertEquals(result, Optional.empty());
    }
}
