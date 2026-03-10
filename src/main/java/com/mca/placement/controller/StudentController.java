package com.mca.placement.controller;

import com.mca.placement.model.Student;
import com.mca.placement.service.CompanyService;
import com.mca.placement.service.StudentService;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller

public class StudentController {
    
     private final StudentService service;
     private final CompanyService companyService;

     //inject both services
    public StudentController(StudentService service,CompanyService companyService) {
        this.service = service;
        this.companyService = companyService;
    }
    
    
    @GetMapping("/students")
    public String viewStudents(Model model,HttpSession session) {

        if(session.getAttribute("admin")==null){
            return "redirect:/login";
        }
        model.addAttribute("students", service.getAllStudents());
        model.addAttribute("student", new Student());
        model.addAttribute("companies", companyService.getAllCompanies());
        model.addAttribute("content","student :: content");

        return "student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        model.addAttribute("students", service.getAllStudents());
        model.addAttribute("companies", companyService.getAllCompanies());
        return "student";
    }

    @GetMapping("/students/search")
    public String searchStudents(@RequestParam("keyword") String keyword, Model model) {

    List<Student> students = service.searchStudent(keyword);

    model.addAttribute("students", students);

    return "student";
}



}
