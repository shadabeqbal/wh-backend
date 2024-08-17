package com.example.wh_backend.utils;

import com.example.wh_backend.config.CommonConfiguration;
import com.example.wh_backend.domain.AllUsers;
import com.example.wh_backend.repository.AllUserRepository;
import com.example.wh_backend.repository.PsychologistProfileRepository;
import com.google.common.hash.Hashing;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CommonUtils {

    @Autowired
    private AllUserRepository allUserRepository;

    @Autowired
    private PsychologistProfileRepository psychologistProfileRepository;

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

    public AllUsers checkUserEmailExists(String email){
        try{
            return allUserRepository.userEmailExists(email);
        }catch (Exception e){
            exceptionLogger.error("Unable to fetch details of user, exception occurred!");
            return null;
        }
    }

    public AllUsers checkUserPassword(String email){
        try{
            return allUserRepository.userEmailExists(email);
        }catch (Exception e){
            exceptionLogger.error("Unable to fetch details of user, exception occurred!");
            return null;
        }
    }

    public Key createSecretKey(String keyString) {
        // Ensure the key string is of appropriate length for HMAC algorithms
        byte[] keyBytes = keyString.getBytes();
        // You should use a key length that matches the HMAC algorithm you are using (e.g., 256 bits for HS256)
        return new SecretKeySpec(keyBytes, "HmacSHA256"); // Replace "HmacSHA256" if using a different algorithm
    }

    public String createJwt(String email, String keyString) {
        Key signingKey = createSecretKey(keyString);

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_00)) // 1 day
                .signWith(signingKey,SignatureAlgorithm.HS256)
                .compact();
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
