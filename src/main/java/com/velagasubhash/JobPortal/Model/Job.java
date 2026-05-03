package com.velagasubhash.JobPortal.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long jobId;
    private String title;
    @Column(length = 2000)
    private String description;
    private String company;
    private String location;
    private Double salary;
    @Enumerated(EnumType.STRING)
    private JobStatus jobStatus;

    @ManyToOne
    private User createdBy;

}
