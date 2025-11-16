package com.example.demo;

import com.example.demo.repositories.PolicyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.demo.repositories")
public class DemoApplication implements CommandLineRunner {


    private final PolicyRepository policyRepository;

    public DemoApplication(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        // Create Policy 1
        Policy rcPolicy = Policy.builder()
                .name("RC")
                .policyId("RC0001")
                .coverages(new ArrayList<>())
                .build();

        Coverage rcCoverage = Coverage.builder()
                .name("RC estacionamiento")
                .coverageId("COV0001")
                .description("Cobertura que cubre gastos de estacionamiento")
                .policyId(rcPolicy.getPolicyId())
                .build();

        rcPolicy.getCoverages().add(rcCoverage);


        // Create Policy 2
        Policy autosPolicy = Policy.builder()
                .name("Autos")
                .policyId("VG0001")
                .coverages(new ArrayList<>())
                .build();

        Coverage autosCoverage = Coverage.builder()
                .name("Accidentes")
                .coverageId("COV002")
                .description("Cubre todo tipo de accidentes en carretera")
                .policyId(autosPolicy.getPolicyId())
                .build();

        autosPolicy.getCoverages().add(autosCoverage);

        var policies = List.of(rcPolicy, autosPolicy);

        policyRepository.saveAll(policies);

    }
}
