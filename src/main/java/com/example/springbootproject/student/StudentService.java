package com.example.springbootproject.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private  StudentRepository studentRepository;
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }


    public void addNewStudent(Student student) throws IllegalAccessException {
       Optional<Student> studentbyEmail= studentRepository.findStudentByEmail(student.getEmail());
        if(studentbyEmail.isPresent()){
            throw new IllegalAccessException("email taken");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long id) {
       boolean exist= studentRepository.existsById(id);
       if(!exist){
           throw new IllegalStateException("student with id" +id+"does not exist");
       }
       studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student =studentRepository.findById(id).orElseThrow(()->new IllegalStateException("Student with id"+id+"does not exist"));
        if(name!=null &&
            name.length()>0 &&
            !Objects.equals(student.getName(),name)
        ){
            student.setName(name);
        }
        if(email!=null &&
                email.length()>0 &&
                !Objects.equals(student.getEmail(),email)
        ){
            Optional<Student> student1=studentRepository.findStudentByEmail(email);
            if(student1.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}
