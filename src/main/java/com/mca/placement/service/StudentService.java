package com.mca.placement.service;

import com.mca.placement.model.Student;
import com.mca.placement.model.Company;
import com.mca.placement.repository.StudentRepository;
import com.mca.placement.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {
    
    private final StudentRepository repository;
    private final CompanyRepository companyRepository;

    public StudentService(StudentRepository repository,CompanyRepository companyRepository) {
        this.repository = repository;
        this.companyRepository = companyRepository;
    }

    //get all students
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    //save students(add/update)
    public Student saveStudent(Student student) {
        
        if (student.getCompany() != null &&
                student.getCompany().getId() != null) {

            Company company = companyRepository
                    .findById(student.getCompany().getId())
                    .orElse(null);

            student.setCompany(company);
        } else {
            student.setCompany(null);
        }

        return repository.save(student);
    }

    //Delete Student
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    //Get Student By ID
    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Student> searchStudent(String keyword) {
    return repository.findByNameContainingIgnoreCase(keyword);
}


}
