package com.zhadan.junior.validator;

import com.zhadan.junior.bean.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 07.07.13
 * Time: 19:22
 */
public class UserValidatorImpl implements UserValidator {
    private int minNameLength;
    private int maxNameLength;
    private int minSurnameLength;
    private int maxSurnameLength;

    public void setMaxNameLength(int maxNameLength) {
        this.maxNameLength = maxNameLength;
    }

    public void setMaxSurnameLength(int maxSurnameLength) {
        this.maxSurnameLength = maxSurnameLength;
    }

    public void setMinNameLength(int minNameLength) {
        this.minNameLength = minNameLength;
    }

    public void setMinSurnameLength(int minSurnameLength) {
        this.minSurnameLength = minSurnameLength;
    }

    private void validateName(String name, HashMap<String, String> errorMap) {
        if (name == null || name.trim().isEmpty()) {
            errorMap.put("name", "Empty name");
        } else if (name.length() < minNameLength) {
            errorMap.put("name", "Too short");
        } else if (name.length() > maxNameLength) {
            errorMap.put("name", "Too long");
        }
    }

    private void validateSurname(String surname, HashMap<String, String> errorMap) {
        if (surname == null || surname.trim().isEmpty()) {
            errorMap.put("surname", "Empty surname");
        } else if (surname.length() < minSurnameLength) {
            errorMap.put("surname", "Too short");
        } else if (surname.length() > maxSurnameLength) {
            errorMap.put("surname", "Too long");
        }
    }

    @Override
    public Map<String, String> validate(User user) {
        HashMap<String, String> errorMap = new HashMap<String, String>();
        validateName(user.getName(), errorMap);
        validateSurname(user.getSurname(), errorMap);
        return errorMap;
    }
}
