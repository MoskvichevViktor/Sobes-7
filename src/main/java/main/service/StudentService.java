package main.service;

import lombok.RequiredArgsConstructor;
import main.model.Student;
import main.repositiry.StudentRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student findById(Long id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    public List<Student> showAll() {
        return new ArrayList<>(studentRepository.findAll());
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public Student saveOrUpdate(Student student) {
        Student entity = null;
        if (student.getId() != null) {
            entity = studentRepository.findById(student.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Student with id " + student.getId() + " doesn't exist!"));
        } else {
            entity = studentRepository.save(new Student(student.getName(), student.getAge()));
        }
        return entity;
    }

}