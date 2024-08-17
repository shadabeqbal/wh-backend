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
@Table(name = "all_users")
public class AllUsers {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "email")
    private String email;

    @Column(name = "email_verified")
    private Boolean emailVerified;

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

    public AllUsers(String cid, String email, String password, AccountType accountType, String dateCreated, String lastUpdatedAt){
        this.id = cid;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.accountStatus = AccountStatus.INACTIVE;
        this.dateCreated = dateCreated;
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
