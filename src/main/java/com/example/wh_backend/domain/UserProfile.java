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
@Table(name = "user_profile")
public class UserProfile {

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

    @Column(name = "education")
    private String education;

    @Column(name = "address")
    private String address;

    @Column(name = "pincode")
    private Integer pincode;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "mental_health_score")
    private Double mentalHealthScore;

    //    A seperate User Reports tables should be made to capture all the reports user will share to doctor
//    and this should or (should not) be a part of profile that is a discussion needs to be done
    @Column(name = "reports")
    @Convert(converter = StringListConverter.class)
    private Set<String> reports;

    @Column(name = "personal_message", columnDefinition = "LONGTEXT")
    private String personalMessage;

    @Column(name = "profile_last_updated_at")
    private String profileLastUpdatedAt;

}
