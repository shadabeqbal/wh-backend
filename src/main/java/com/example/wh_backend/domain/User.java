package com.example.wh_backend.domain;


import com.example.wh_backend.utils.AccountStatus;
import com.example.wh_backend.utils.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "email_verified")
    private Boolean emailVerified;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "mobile_verified")
    private Boolean mobileVerified;

    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "account_active")
    private Boolean accountActive;

    @Column(name = "account_status")
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @Column(name = "account_deleted")
    private Boolean accountDeleted;

    @Column(name = "date_created")
    private String dateCreated;

    @Column(name = "password")
    private String password;

    @Column(name = "last_updated_at")
    private String lastUpdatedAt;

    public User(String cid, String name, String email, String mobile, String password, AccountType accountType, String dateCreated, String lastUpdatedAt){
        this.id = cid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.accountType = accountType;
        this.accountStatus = AccountStatus.INACTIVE;
        this.dateCreated = dateCreated;
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
