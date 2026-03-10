package com.mca.placement.repository;

import com.mca.placement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

      // Count students who are placed in a company
    long countByCompanyIsNotNull();
    long countByCompanyIsNull();
    List<Student> findByNameContainingIgnoreCase(String name);
    List<Student> findTop5ByCompanyIsNotNullOrderByIdDesc();
}
