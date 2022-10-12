package com.example.lab1.util;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidateField {
    public boolean validField(String value, String patternString) {
        Pattern pattern = Pattern.compile("^" + patternString + "$");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    public boolean validEmail(String email) {
        return validField(email, "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}");
    }
    public boolean validPassword(String password) {
        return validField(password, "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}");
    }

    public boolean validUsername(String username) {
        return validField(username, "[a-zA-Z0-9]{5,}");
    }
    public boolean validFullname(String fullname) {
        return validField(fullname, "^[a-zA-Z]{2,}(?: [a-zA-Z]+){1,}$");
    }

}
