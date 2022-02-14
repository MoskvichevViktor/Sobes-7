package main.controller;

import lombok.RequiredArgsConstructor;
import main.model.Student;
import main.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/students")
    public List<Student> showAll() {

        return studentService.showAll();
    }

    @GetMapping("/{id}/id")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @DeleteMapping("/{id}/id")
    public void deleteStudentById(@PathVariable Long id) {

        studentService.deleteById(id);
    }

    @PostMapping("/newStudent")
    @ResponseStatus(HttpStatus.CREATED)
    public Student saveNewStudent(@RequestBody Student student) {
        student.setId(null);
        return studentService.saveOrUpdate(student);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {

        return studentService.saveOrUpdate(student);
    }

}
