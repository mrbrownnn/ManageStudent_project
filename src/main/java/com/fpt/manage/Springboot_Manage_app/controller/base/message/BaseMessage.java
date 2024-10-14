package com.fpt.manage.Springboot_Manage_app.controller.base.message;

import lombok.AllArgsConstructor;
import  lombok.Getter;
import lombok.NoArgsConstructor;
import  lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// structure of message
public class BaseMessage {

        private String code;

        private Boolean success;

        private String message;

        private String description;


}
