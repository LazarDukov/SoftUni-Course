package softuni.hateoas.service;

import org.springframework.stereotype.Service;
import softuni.hateoas.model.dto.OrderDTO;
import softuni.hateoas.model.dto.StudentDTO;
import softuni.hateoas.model.entity.OrderEntity;
import softuni.hateoas.model.entity.StudentEntity;
import softuni.hateoas.repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(this::map).toList();
    }

    private StudentDTO map(StudentEntity studentEntity) {
        var orders = studentEntity.getOrders().stream().map(this::map).toList();
        return new StudentDTO()
                .setAge(studentEntity.getAge())
                .setName(studentEntity.getName())
                .setId(studentEntity.getId())
                .setDeleted(studentEntity.isDeleted())
                .setOrders(orders);
    }

    private OrderDTO map(OrderEntity orderEntity) {
        return new OrderDTO().setStudentId(orderEntity.getStudent().getId())
                .setCourseId(orderEntity.getCourse().getId());
    }

    public Optional<StudentDTO> getStudentById(Long studentId) {
        return studentRepository.findById(studentId).map(this::map);
    }
}
