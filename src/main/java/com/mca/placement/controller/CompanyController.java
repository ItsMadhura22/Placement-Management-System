package com.mca.placement.controller;

import com.mca.placement.model.Company;
import com.mca.placement.service.CompanyService;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CompanyController {
    
 private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

   
    @GetMapping("/companies")
    public String viewCompanies(Model model,HttpSession session) {

        if(session.getAttribute("admin")==null){
            return "redirect:/login";
        }
        model.addAttribute("companies", service.getAllCompanies());
        model.addAttribute("company", new Company());
        model.addAttribute("content","company :: content");

        return "company";
    }

    @PostMapping("/companies")
    public String saveCompany(@ModelAttribute Company company) {
        service.saveCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/companies/delete/{id}")
    public String deleteCompany(@PathVariable Long id) {
        service.deleteCompany(id);
        return "redirect:/companies";
    }

    @GetMapping("/companies/edit/{id}")
    public String editCompany(@PathVariable Long id, Model model) {
        model.addAttribute("company", service.getCompanyById(id));
        model.addAttribute("companies", service.getAllCompanies());
        return "company";
    }

}
