package com.klef.soa.exam.service;

import java.time.LocalDate;
import java.util.List;

import com.klef.soa.exam.entity.Medicine;
public interface MedicineService
{
    Medicine addMedicine(Medicine medicine);

    Medicine updateMedicine(Medicine medicine);

    String deleteMedicineById(Long medicineId);

    List<Medicine> displayAllMedicines();

    Medicine displayMedicineById(Long medicineId);

    List<Medicine> displayMedicinesByCompany(String company);

    List<Medicine> displayMedicinesByExpiryDate(LocalDate expiryDate);

	List<Medicine> displayMedicinesByExpiryDate1(LocalDate expiryDate);
}