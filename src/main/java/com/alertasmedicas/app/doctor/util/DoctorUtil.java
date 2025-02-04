package com.alertasmedicas.app.doctor.util;

import org.springframework.stereotype.Component;

@Component
public class DoctorUtil {

    private DoctorUtil() {}

    public static boolean isEmptyOrNull(String string) {
        return null == string || string.isEmpty();
    }
}
