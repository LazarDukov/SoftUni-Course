package softuni.hateoas.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softuni.hateoas.model.dto.StudentDTO;
import softuni.hateoas.service.StudentService;

import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public ResponseEntity<List<StudentDTO>> all() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<StudentDTO>> getStudentsById(@PathVariable("id") String id) {
        throw new UnsupportedOperationException("Not yet");
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<List<StudentDTO>> getStudentOrders(@PathVariable("id") String id) {
        throw new UnsupportedOperationException("Not yet");
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<StudentDTO>> updateStudent() {
        throw new UnsupportedOperationException("Not yet");
    }

}
