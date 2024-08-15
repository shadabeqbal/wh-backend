package com.example.wh_backend.service;


import com.example.wh_backend.config.CommonConfiguration;
import com.example.wh_backend.domain.User;
import com.example.wh_backend.email.EmailService;
import com.example.wh_backend.models.request.UserLoginInput;
import com.example.wh_backend.models.request.UserRegisterInput;
import com.example.wh_backend.models.response.GlobalResponse;
import com.example.wh_backend.models.response.RegisterResponse;
import com.example.wh_backend.repository.UserRepository;
import com.example.wh_backend.utils.AccountStatus;
import com.example.wh_backend.utils.AccountType;
import com.example.wh_backend.utils.CommonUtils;
import com.example.wh_backend.utils.ErrorCodes;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private CommonUtils commonUtils;

    @Autowired
    private CommonConfiguration commonConfiguration;

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private static final Logger exceptionLogger = LoggerFactory.getLogger("ExceptionLog");
    private static final Logger errorMessagesLogger = LoggerFactory.getLogger("Error Messages");

    public GlobalResponse registerUser(UserRegisterInput userRegisterInput){
        GlobalResponse globalResponse;
        try{
            Boolean emailValid = commonUtils.EmailFilter(userRegisterInput.getEmail());
            if(!emailValid)
                return new GlobalResponse(false, ErrorCodes.ALLOWED_EMAIL_DOMAIN_NOT_EXIST,HttpStatus.SC_OK,"Allowed Email Domains are: "+String.join(", ",commonConfiguration.getAllowedEmailDomains()));

            String hashPassword = commonUtils.encryptPassword(userRegisterInput.getPassword());
            String key = commonUtils.generateKey(userRegisterInput.getEmail().split("@")[0], AccountType.USER);
            String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
            Boolean emailExists = commonUtils.checkUserEmailExists(userRegisterInput.getEmail());

            if(!emailExists) {
                User userTable = new User(key, userRegisterInput.getName(), userRegisterInput.getEmail(), false, null, false,userRegisterInput.getAccountType(), false, AccountStatus.INACTIVE, false, currentDateTime, hashPassword, currentDateTime);
                userRepository.save(userTable);
                RegisterResponse registerResponse = new RegisterResponse();
                registerResponse.setName(userTable.getName());
                registerResponse.setEmail(userTable.getEmail());
                userRegisterInput.setPassword(hashPassword);
                emailService.sendEmailOnUserRegistration(userRegisterInput);
                globalResponse = new GlobalResponse(true, null, HttpStatus.SC_OK, registerResponse);
            }else{
                globalResponse = new GlobalResponse(false,ErrorCodes.EMAIL_EXISTS,HttpStatus.SC_OK,null);
            }
        }catch(Exception e){
            exceptionLogger.error("There is some error registering user"+e.getLocalizedMessage());
            globalResponse = new GlobalResponse(false, ErrorCodes.ACCOUNT_REGISTRATION_ERROR, HttpStatus.SC_INTERNAL_SERVER_ERROR,e.getMessage());
        }

        return globalResponse;
    }

    public GlobalResponse loginUser(UserLoginInput userLoginInput){
        GlobalResponse globalResponse;
        try{
            Boolean emailValid = commonUtils.EmailFilter(userLoginInput.getEmail());
            if(!emailValid)
                return new GlobalResponse(false, ErrorCodes.ALLOWED_EMAIL_DOMAIN_NOT_EXIST,HttpStatus.SC_OK,"Allowed Email Domains are: "+String.join(", ",commonConfiguration.getAllowedEmailDomains()));

            String hashPassword = commonUtils.encryptPassword(userLoginInput.getPassword());
            String key = commonUtils.generateKey(userLoginInput.getEmail().split("@")[0], userLoginInput.getAccountType());
            String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
            Boolean emailExists = commonUtils.checkUserEmailExists(userLoginInput.getEmail());

            if(emailExists) {
                User user = commonUtils.checkUserPassword(userLoginInput.getEmail(), hashPassword);

                if(user != null) {
                    String token = commonUtils.createJwt(userLoginInput.getEmail(), key);

                    user.setLastUpdatedAt(currentDateTime);
                    userRepository.save(user);
                    globalResponse = new GlobalResponse(true, null, HttpStatus.SC_OK, token);
                }else {
                    globalResponse = new GlobalResponse(false, ErrorCodes.INVALID_PASSWORD, HttpStatus.SC_OK, null);
                }
            }else{
                globalResponse = new GlobalResponse(false,ErrorCodes.EMAIL_NOT_EXISTS,HttpStatus.SC_OK,null);
            }
        }catch(Exception e){
            exceptionLogger.error("There is some error registering user"+e.getLocalizedMessage());
            globalResponse = new GlobalResponse(false, ErrorCodes.ACCOUNT_LOGIN_ERROR, HttpStatus.SC_INTERNAL_SERVER_ERROR,e.getMessage());
        }

        return globalResponse;
    }
}
