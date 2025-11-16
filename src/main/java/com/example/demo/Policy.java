package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Policy {
    @Id
    private String policyId;
    private String name;

    @OneToMany(mappedBy = "policyId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Column(insertable = false)
    private List<Coverage> coverages = new ArrayList<>();
}
