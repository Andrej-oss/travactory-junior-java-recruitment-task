package com.travactory.recruitment.junior.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class LocalDateTimeFormatter {

    public static LocalDateTime getLocalDateTimeWithOffSet(Date date, Integer offSet) {
        return  date.toInstant().atOffset(ZoneOffset.ofHours(offSet)).toLocalDateTime();
    }
}
