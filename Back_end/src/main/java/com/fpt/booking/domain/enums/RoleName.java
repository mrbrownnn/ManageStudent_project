package com.fpt.booking.domain.enums;

public enum RoleName {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_DRIVER("ROLE_DRIVER");


    private String value;

    RoleName(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
