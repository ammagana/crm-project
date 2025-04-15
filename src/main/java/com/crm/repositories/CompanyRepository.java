package com.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    
}
