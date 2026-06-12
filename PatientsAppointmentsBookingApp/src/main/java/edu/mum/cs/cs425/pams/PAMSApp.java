package edu.mum.cs.cs425.pams;

import edu.mum.cs.cs425.pams.model.Patient;
import edu.mum.cs.cs425.pams.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class PAMSApp implements CommandLineRunner {

    @Autowired
    private PatientService patientService;

    public static void main(String[] args) {
        SpringApplication.run(PAMSApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Patient[] patients = new Patient[]{
                new Patient(1L, "Daniel", "Agar", "(641) 123-0009", "dagar@m.as", "1 N Street", LocalDate.of(1987, 1, 19)),
                new Patient(2L, "Ana", "Smith", null, "amsith@te.edu", null, LocalDate.of(1948, 12, 5)),
                new Patient(3L, "Marcus", "Garvey", "(123) 292-0018", null, "4 East Ave", LocalDate.of(2001, 9, 18)),
                new Patient(4L, "Jeff", "Goldbloom", "(999) 165-1192", "jgold@es.co.za", null, LocalDate.of(1995, 2, 28)),
                new Patient(5L, "Mary", "Washington", null, null, "30 W Burlington", LocalDate.of(1932, 5, 31))
        };

        patientService.saveAllPatients(patients);

        System.out.println("JSON output of all patients sorted by Age (Oldest first):");
        patientService.printPatientsSortedByAgeJson();
    }
}
