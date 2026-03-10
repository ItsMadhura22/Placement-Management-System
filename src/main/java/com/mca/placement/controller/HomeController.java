package com.mca.placement.controller;

import com.mca.placement.repository.StudentRepository;
import com.mca.placement.repository.CompanyRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/")
    public String dashboard(Model model, HttpSession session) {

        if(session.getAttribute("admin") == null){
            return "redirect:/login";
        }

        long studentCount = studentRepository.count();
        long companyCount = companyRepository.count();
        long placedCount = studentRepository.countByCompanyIsNotNull();
        long notPlacedCount = studentRepository.countByCompanyIsNull();

        model.addAttribute("studentCount", studentCount);
        model.addAttribute("companyCount", companyCount);
        model.addAttribute("placedCount", placedCount);
        model.addAttribute("notPlacedCount", notPlacedCount);

        model.addAttribute("recentPlacements",studentRepository.findTop5ByCompanyIsNotNullOrderByIdDesc());

        return "dashboard";
    }
}
