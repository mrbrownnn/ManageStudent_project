package com.fpt.manage.Springboot_Manage_app.utils;

public class Regex {
    public static final String USER_ID = "(0[3|5|7|8|9])+([0-9]{8})";
    public static final String PASSWORD_VALIDATION ="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,20}$";

}

