package com.klef.soa.exam.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.exam.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long>
{
    List<Medicine> findByCompany(String company);

    List<Medicine> findByExpiryDate(LocalDate expiryDate);
}