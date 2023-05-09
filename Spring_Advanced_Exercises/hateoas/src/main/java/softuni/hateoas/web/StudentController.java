package softuni.hateoas.web;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softuni.hateoas.model.dto.StudentDTO;
import softuni.hateoas.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<StudentDTO>>> all() {

        final List<EntityModel<StudentDTO>> entityModels = studentService.getAllStudents().stream().map(studentDTO -> EntityModel.of(studentDTO, getStudentLinks(studentDTO))).toList();
        final CollectionModel<EntityModel<StudentDTO>> collectionModel = CollectionModel.of(entityModels);
        return ResponseEntity.ok(collectionModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<StudentDTO>> getStudentsById(@PathVariable("id") Long id) {
        var studentOptional = studentService.getStudentById(id);

        return studentOptional.map(studentDTO ->
                        ResponseEntity.ok(EntityModel.of(studentDTO, getStudentLinks(studentDTO))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<List<StudentDTO>> getStudentOrders(@PathVariable("id") Long id) {
        throw new UnsupportedOperationException("Not yet");
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<StudentDTO>> updateStudent(@PathVariable("id") Long id, StudentDTO studentDTO) {
        throw new UnsupportedOperationException("Not yet");
    }

    private Link[] getStudentLinks(StudentDTO studentDTO) {
        List<Link> studentLinks = new ArrayList<>();
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudentsById(studentDTO.getId())).withSelfRel();

        studentLinks.add(selfLink);

        if (!studentDTO.isDeleted()) {
            Link orderLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudentOrders(studentDTO.getId())).withRel("orders");
            Link updateLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).updateStudent(studentDTO.getId(), studentDTO)).withRel("update");

            studentLinks.add(orderLink);
            studentLinks.add(updateLink);

        }
        return studentLinks.toArray(new Link[0]);
    }

}
