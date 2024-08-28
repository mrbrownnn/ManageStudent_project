package com.fpt.booking.domain.enums;

public enum RoleName {
    ROLE_USER("ROLE_STUDENT"),
    ROLE_ADMIN("ROLE_TEACHER"),
    ROLE_DRIVER("ROLE_MANAGER");


    private String value;

    RoleName(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
