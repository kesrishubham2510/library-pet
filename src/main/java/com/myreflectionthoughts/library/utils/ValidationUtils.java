package com.myreflectionthoughts.library.utils;

import com.myreflectionthoughts.library.exception.InputDataException;
import com.myreflectionthoughts.library.exception.ParameterMissingException;

import java.util.List;

public class ValidationUtils {

    private final static List<String> emailDomains;
    public final static byte passwordLength;
    public final  static byte masterAgeThreshold;

    static {
        emailDomains = List.of("gmail.com","facebook.com","yopmail.com");
        passwordLength = 6;
        masterAgeThreshold = 16;

    }

    public static void validateString(String value,String name){
        if(null==value)
            throw new ParameterMissingException(String.format("%s is required, it can't be null",name));
        if(value.trim().isEmpty())
            throw new InputDataException(String.format("%s is required, it can't null or empty or whitespaces",name));
    }

    public static void validateEmail(String email){
        ValidationUtils.validateString(email, "Email ID");
        if(!ValidationUtils.emailDomains.contains(email.split("@")[1]))
            throw new InputDataException("Email must contain one of these domains [gmail.com, facebook.com, yopmail.com]");
    }

    public static void validatePassword(String password){
        ValidationUtils.validateString(password, "Password");
        if(password.trim().length()<passwordLength)
            throw new InputDataException(String.format("Password should be atleast %s characters long",passwordLength));
    }

    public static void validateAge(double age){
        if(age<=0)
            throw new InputDataException("Age can't be zero or negative, Please provide a valid age");
        if(age< masterAgeThreshold)
            throw new InputDataException(String.format("Please provide a valid age, it should be atleast %s years old", masterAgeThreshold));
    }

    public static void validatePetAge(double petAge){
        if(petAge<=0)
            throw new InputDataException("Age can't be zero or negative, Please provide a Valid age for your pet");
    }

    public static List<String> validationExceptions(){
        return List.of(InputDataException.class.getSimpleName(), ParameterMissingException.class.getSimpleName());
    }
}
