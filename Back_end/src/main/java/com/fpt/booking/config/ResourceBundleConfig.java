package com.fpt.booking.config;

import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class ResourceBundleConfig {

    private final ResourceBundle labelsVi;
    private final ResourceBundle labelsEn;

    public ResourceBundleConfig() {
        Locale localeVi = new Locale("vi");
        labelsVi = ResourceBundle.getBundle("languages/messages", localeVi);

        Locale localeEn = new Locale("en");
        labelsEn = ResourceBundle.getBundle("languages/messages", localeEn);
    }

    public String getViMessage(String key){
        return labelsVi.getString(key);
    }

    public String getEnMessage(String key){
        return labelsEn.getString(key);
    }

    public String getEnMessage(String key, Object... arguments) {
        return MessageFormat.format(getEnMessage(key), arguments);
    }

    public String getViMessage(String key, Object... arguments) {
        return MessageFormat.format(getViMessage(key), arguments);
    }
}