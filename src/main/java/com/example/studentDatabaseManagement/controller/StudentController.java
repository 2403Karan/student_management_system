package com.example.studentDatabaseManagement.controller;
import com.example.studentDatabaseManagement.dto.AddStudentDto;
import com.example.studentDatabaseManagement.dto.StudentDto;
import com.example.studentDatabaseManagement.services.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController//springboot handle this class automatically
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<StudentDto> getStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return studentService.getStudents(page, size);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createStudent(@RequestBody @Valid AddStudentDto addStudentDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.insertStudent(addStudentDto));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updatePartialStudentInfo(@PathVariable long id,
                                                               @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentService.updateStudentInfo(id,updates));
    }
}

