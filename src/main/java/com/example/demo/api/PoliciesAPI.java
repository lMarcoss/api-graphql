package com.example.demo.api;

import com.example.demo.Policy;
import com.example.demo.repositories.PolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PoliciesAPI {

    private final PolicyRepository policyRepository;


    @QueryMapping(name = "policies")
    public List<Policy> policies() {
        return policyRepository.findAll();
    }

}
