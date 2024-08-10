package com.example.wh_backend.domain.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Converter
public class ObjectConverter implements AttributeConverter<Object,String> {
    private static final Logger exceptionLogger = LoggerFactory.getLogger("ExceptionLog");
    @Override
    public String convertToDatabaseColumn(Object stringList){
        ObjectMapper objectMapper = new ObjectMapper();
        String objectStatsJson = null;
        try{
            if(stringList != null){
                objectStatsJson = objectMapper.writeValueAsString(stringList);
            }
        }catch (final JsonProcessingException e){
            exceptionLogger.error("JSON writing error",e);
        }

        return objectStatsJson;
    }

    @Override
    public Object convertToEntityAttribute(String objectStatsJson){
        ObjectMapper objectMapper = new ObjectMapper();
        Object objectStats = null;
        try{
            if(objectStatsJson != null){
                objectStats = objectMapper.readValue(objectStatsJson, Object.class);
            }
        }catch (final IOException e){
            exceptionLogger.error("JSON reading error", e);
        }

        return objectStats;
    }
}
