package com.example.studentDatabaseManagement.services.implementation;
import com.example.studentDatabaseManagement.dto.AddStudentDto;
import com.example.studentDatabaseManagement.dto.StudentDto;
import com.example.studentDatabaseManagement.entity.Student;
import com.example.studentDatabaseManagement.repository.StudentRepository;
import com.example.studentDatabaseManagement.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor //automatically creates constructor
public class StudentImplementation implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public List<StudentDto> getStudents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size); // page is 0-based
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage.getContent()
                .stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto getStudentById(long id) {
        Student student= studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Student not found with id:"+id) );
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto insertStudent(AddStudentDto addStudentDto) {
        Student newStudent = modelMapper.map(addStudentDto,Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudentById(long id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
        }
        else{
            throw new IllegalArgumentException("Student not found with id:"+id);
        }
    }


    @Override
    public StudentDto updateStudentInfo(long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));

        updates.forEach((fields, value) -> {
            switch (fields) {
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                case "gender":
                    student.setGender((String) value);
                    break;
                case "phoneNumber":
                    student.setPhoneNumber((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported to update:");
            }
        });

        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }
}
