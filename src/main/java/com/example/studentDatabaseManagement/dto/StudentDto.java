package com.example.studentDatabaseManagement.dto;

import lombok.AllArgsConstructor;// it  generate all argument constructor
import lombok.Data;//it automatically make setter getter when object is made
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private long Id;
    private String Name;
    private String Gender;
    private String Email;
    private String PhoneNumber;

}
