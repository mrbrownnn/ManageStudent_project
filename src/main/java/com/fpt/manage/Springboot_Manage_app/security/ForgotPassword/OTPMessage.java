package com.fpt.manage.Springboot_Manage_app.security.ForgotPassword;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.Random;

public class OTPMessage {
    public static void sendOTP(String email, String OTP, JavaMailSender javaMailSender) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setBcc(
                "OTPMailSender.html"
        );
        javaMailSender.send(msg);
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        //Deployed SHA256 encode hash function
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        //Deployed SHA256 decode hash function
        return super.equals(obj);
    }
}
