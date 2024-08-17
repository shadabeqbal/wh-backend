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
@Table(name = "pathlabs_profile")
public class PathLabsProfile {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "ref_id", referencedColumnName = "id")
    private AllUsers refId;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "mobile_verified")
    private Boolean mobileVerified;

    @Column(name = "address")
    private String address;

    @Column(name = "pincode")
    private Integer pincode;

    @Column(name = "website")
    @Convert(converter = StringListConverter.class)
    private Set<String> website;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "speciality")
    @Convert(converter = StringListConverter.class)
    private Set<String> speciality;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "registrationId")
    private String registrationId;

    @Column(name = "license")
    private String license;

    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "services")
    @Convert(converter = StringListConverter.class)
    private Set<String> services;

    @Column(name = "profile_last_updated_at")
    private String profileLastUpdatedAt;

}
