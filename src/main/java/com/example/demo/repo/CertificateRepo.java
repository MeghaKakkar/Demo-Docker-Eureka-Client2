package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Certificate;

@Repository
public interface CertificateRepo extends JpaRepository<Certificate, Integer> {

}
