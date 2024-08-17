package com.example.wh_backend.domain;


import com.example.wh_backend.domain.converters.StringListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fitness_trainer_profile")
public class FitnessTrainerProfile {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "ref_id", referencedColumnName = "id")
    private AllUsers refId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "mobile_verified")
    private Boolean mobileVerified;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "pincode")
    private Integer pincode;

    @Column(name = "education")
    private String education;

    @Column(name = "experience")
    private String experience;

    @Column(name = "speciality")
    @Convert(converter = StringListConverter.class)
    private Set<String> speciality;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "resume")
    private String resume;

    @Column(name = "language_known")
    @Convert(converter = StringListConverter.class)
    private Set<String> languagesKnown;

    @Column(name = "personal_message", columnDefinition = "LONGTEXT")
    private String personalMessage;

    @Column(name = "profile_last_updated_at")
    private String profileLastUpdatedAt;

}
