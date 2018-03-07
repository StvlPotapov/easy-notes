package com.example.easynotes.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resoursName;
    private String fieldName;
    private Object fieldValue;


    public ResourceNotFoundException(String resoursName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resoursName, fieldName, fieldValue));
        this.resoursName = resoursName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getResoursName() {
        return resoursName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }


}
