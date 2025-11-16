package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coverage {

    @Id
    private String coverageId;

    private String name;
    private String description;
    private String policyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policyId", insertable = false, updatable = false)
    private Policy policy;

}
