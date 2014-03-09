package com.zhadan.junior.validator;


import com.zhadan.junior.bean.User;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 07.07.13
 * Time: 19:22
 */
public interface UserValidator {
    public Map<String, String> validate(User user);
}
