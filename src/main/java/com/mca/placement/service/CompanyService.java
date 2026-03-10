package com.mca.placement.service;

import com.mca.placement.model.Company;
import com.mca.placement.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

  private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    public void saveCompany(Company company) {
        repository.save(company);
    }

    public void deleteCompany(Long id) {
        repository.deleteById(id);
    }

    public Company getCompanyById(Long id) {
        return repository.findById(id).orElse(null);
    }  

}

