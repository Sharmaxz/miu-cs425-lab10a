package edu.mum.cs.cs425.pams.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.mum.cs.cs425.pams.model.Patient;
import edu.mum.cs.cs425.pams.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public void saveAllPatients(Patient[] patients) {
        patientRepository.saveAll(patients);
    }

    public void printPatientsSortedByAgeJson() {
        List<Patient> patients = patientRepository.findAll();
        List<Patient> sortedPatients = patients.stream()
                .sorted(Comparator.comparing(Patient::getAge).reversed())
                .collect(Collectors.toList());

        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sortedPatients);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            System.err.println("Error processing JSON: " + e.getMessage());
        }
    }
}
