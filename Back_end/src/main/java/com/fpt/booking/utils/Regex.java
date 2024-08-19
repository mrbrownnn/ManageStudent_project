package com.fpt.booking.utils;

public class Regex {
    public static final String PHONE_VALIDATION = "(0[3|5|7|8|9])+([0-9]{8})";

    public static final String PASSWORD_VALIDATION ="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,20}$";

}
