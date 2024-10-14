package com.fpt.manage.Springboot_Manage_app.controller.base.message;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class MessageResponse extends BaseMessage {
    private String MessageNameResponse;
}
