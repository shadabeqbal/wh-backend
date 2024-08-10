package com.example.wh_backend.utils;

import com.example.wh_backend.config.CommonConfiguration;
import com.example.wh_backend.domain.User;
import com.example.wh_backend.repository.PhysicianRepository;
import com.example.wh_backend.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

@Service
public class CommonUtils {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhysicianRepository physicianRepository;

    @Autowired
    private CommonConfiguration commonConfiguration;

    private static final Logger exceptionLogger = LoggerFactory.getLogger("ExceptionLog");

    public String encryptPassword(String password){
        return Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
    }

    public String generateKey(String name,AccountType accountType){
        String[] tempName = name.split(" ",2);
        Random rnd = new Random();
        int randomNum = Math.abs(rnd.nextInt());
        return accountType.toString()+"__"+tempName[0]+"__"+randomNum;
    }

    public Boolean checkUserEmailExists(String email){
        try{
            User userDetails = userRepository.userEmailExists(email);
            return userDetails != null;
        }catch (Exception e){
            exceptionLogger.error("Unable to fetch details of user, exception occurred!");
            return false;
        }
    }

    public Boolean checkUserMobileExists(String mobile){
        try{
            User userDetails = userRepository.userMobileExists(mobile);
            return userDetails != null;
        }catch (Exception e){
            exceptionLogger.error("Unable to fetch details of user, exception occurred!");
            return false;
        }
    }

    public Boolean EmailFilter(String email){
        try{
            List<String> allowedEmail = commonConfiguration.getAllowedEmailDomains();
            for(String each : allowedEmail){
                if(email.contains(each))
                    return true;
            }
        }catch (Exception e){
            exceptionLogger.error("Unable to fetch details of user, exception occurred!");
            return false;
        }

        return false;
    }
}
