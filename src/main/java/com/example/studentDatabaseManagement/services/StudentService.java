package com.example.studentDatabaseManagement.services;

import com.example.studentDatabaseManagement.dto.AddStudentDto;
import com.example.studentDatabaseManagement.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService
{
    List<StudentDto> getStudents(int page,int size);

    StudentDto getStudentById(long id);

    StudentDto insertStudent(AddStudentDto addStudentDto);

    void deleteStudentById(long id);

//    StudentDto updateStudent(long id, AddStudentDto addStudentDto);

    StudentDto updateStudentInfo(long id, Map<String, Object> updates);
}
