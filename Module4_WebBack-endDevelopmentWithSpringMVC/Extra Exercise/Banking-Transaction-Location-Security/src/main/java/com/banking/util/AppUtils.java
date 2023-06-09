package com.banking.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppUtils {

    public ResponseEntity<?> mapErrorToResponse(BindingResult result) {
        List<FieldError> errorList = result.getFieldErrors();

        Map<String,String > errorMap = new HashMap<>();

        for (FieldError fieldError : errorList) {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
//            errorMap.put(fieldError.getField(), fieldError.getCode());
        }

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<?> mapErrorPlus(BindingResult result, Map<String, String> extraErrors) {
        List<FieldError> errorList = result.getFieldErrors();

        Map<String,String > errorMap = new HashMap<>();

        if (!extraErrors.isEmpty()) {
            errorMap.putAll(extraErrors);
        }

        if (result.hasErrors()) {
            for (FieldError fieldError : errorList) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

}
