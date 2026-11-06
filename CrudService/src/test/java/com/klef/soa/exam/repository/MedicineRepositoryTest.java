
package com.klef.soa.exam.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.exam.entity.Medicine;

@DataJpaTest
@AutoConfigureTestDatabase(
    replace = AutoConfigureTestDatabase.Replace.NONE
)
class MedicineRepositoryTest {

    @Autowired
    private MedicineRepository repository;

    private Medicine medicine;

    @BeforeEach
    void setUp() {
        repository.deleteAll();

        medicine = new Medicine();
        medicine.setMedicineName("Paracetamol");
        medicine.setCompany("ABC Pharma");
        medicine.setExpiryDate(LocalDate.of(2027, 12, 31));
        medicine.setPrice(50.0);
        medicine.setStock(100);

        medicine = repository.saveAndFlush(medicine);
    }

    @Test
    void testFindAll() {
        List<Medicine> medicines = repository.findAll();

        assertEquals(1, medicines.size());
    }

    @Test
    void testFindById() {
        Medicine found = repository
                .findById(medicine.getMedicineId())
                .orElse(null);

        assertNotNull(found);
        assertEquals("Paracetamol", found.getMedicineName());
    }

    @Test
    void testDerivedQuery() {
        List<Medicine> result =
                repository.findByCompany("ABC Pharma");

        assertFalse(result.isEmpty());
        assertEquals("ABC Pharma",
                result.get(0).getCompany());
    }

    @Test
    void testCount() {
        long count = repository.count();

        assertEquals(1, count);
    }

    @Test
    void testEntityDetails() {
        assertEquals("Paracetamol",
                medicine.getMedicineName());

        assertEquals(100, medicine.getStock());
        assertEquals(50.0, medicine.getPrice());
    }

}
