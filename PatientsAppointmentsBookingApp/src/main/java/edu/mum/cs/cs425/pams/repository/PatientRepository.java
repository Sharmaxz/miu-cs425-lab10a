package edu.mum.cs.cs425.pams.repository;

import edu.mum.cs.cs425.pams.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PatientRepository {
    private List<Patient> patients = new ArrayList<>();

    public void saveAll(Patient[] newPatients) {
        patients.addAll(Arrays.asList(newPatients));
    }

    public List<Patient> findAll() {
        return patients;
    }
}
