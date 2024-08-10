package com.example.wh_backend.models.response;

import com.example.wh_backend.models.exception.ExceptionErrorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class GlobalResponse {

    private boolean success;
    private ExceptionErrorModel errorCode;
    private int statusCode;
    private Object response;

}
