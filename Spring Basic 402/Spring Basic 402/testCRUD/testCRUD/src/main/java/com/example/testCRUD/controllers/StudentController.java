package com.example.testCRUD.controllers;

import com.example.testCRUD.Services.StudentService;
import com.example.testCRUD.entities.Student;
import com.example.testCRUD.repositories.StudentRepository;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    @PostMapping("/create") // Crea un nuovo Student e lo salva con .save
    public @ResponseBody Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/allStud") //Ottiene la lista di tutti gli Studenti
    public @ResponseBody List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @GetMapping("/{Id}")
    // prende uno studente specifico tramite id, si usa findById e se lo studente non viene trovato viene lanciata un ecezzione di tipo illegalArgument
    public @ResponseBody Student getStudentById(@PathVariable Long Id) {
        return studentRepository.findById(Id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + Id));
    }

    @PutMapping("/{studentId}") // questo prendo l'id e un oggetto student con il quale
    public @ResponseBody Student updateStudent(@PathVariable Long studentId, @RequestBody  @NotNull Student updatedStudent) {
        Student student = studentRepository.findById(studentId) //viene fatta una cerca tramite id
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + studentId));

        student.setName(updatedStudent.getName());
        student.setSurname(updatedStudent.getSurname());
        student.setWorking(updatedStudent.isWorking());

        return studentRepository.save(student);
    }

    @PutMapping("/{studentId}/working") // aggiorna il valore isWorking passando l'id
    public @ResponseBody Student updateWorkingStatus(@PathVariable Long studentId, @RequestParam boolean working) {
        return studentService.changeWorkingStatus(studentId, working);
    }

    @DeleteMapping("/{studentId}") // cancella uno studente
    public void deleteStudent(@PathVariable Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
