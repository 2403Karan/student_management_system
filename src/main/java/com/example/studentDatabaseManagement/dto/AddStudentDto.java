package com.example.studentDatabaseManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data

public class AddStudentDto {

        @NotBlank(message = "Name is Required")
        @Size(min=3,max=20,message = "Name should be of length grater than 3 and less than 20")
        private String Name;

        private String Gender;

        @Email
        @NotBlank(message = "Name is Required")
        private String Email;

        @Size(min=10,message = "phoneNumber must be atleast 10 digits")
        private String PhoneNumber;

}
