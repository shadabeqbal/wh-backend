package com.example.wh_backend.models.request;

import com.example.wh_backend.utils.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterInput {
    private String email;
    private String password;
    private AccountType accountType;
}
