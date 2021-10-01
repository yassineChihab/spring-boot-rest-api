package com.example.springbootproject.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController{

    @Autowired
    private   StudentService studentService;
    @GetMapping
    public List<Student> getStudent(){
        return  studentService.getStudent();

    }
    @PostMapping
    public void registerNewStudent(@RequestBody  Student student) throws IllegalAccessException {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent( @PathVariable("studentId")  Long id){
            studentService.deleteStudent(id);

    }
    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long id,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String email
    ){
        studentService.updateStudent(id,name,email);
    }
}
