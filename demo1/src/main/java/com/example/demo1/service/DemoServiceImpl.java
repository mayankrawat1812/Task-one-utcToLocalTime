package com.example.demo1.service;

import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class DemoServiceImpl implements DemoService{
    public String localTime(){
        LocalDate currentDate=LocalDate.now();
        LocalTime currentTime=LocalTime.now();
        ZoneId myZone= ZoneId.systemDefault();
        ZonedDateTime zonedDateTime=ZonedDateTime.of(currentDate,currentTime,myZone);
        LocalDateTime currentDateTime=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        DateTimeFormatter zoneAbbreviationFormatter = DateTimeFormatter.ofPattern("zzz", Locale.ENGLISH);
        String currentAbbreviation = zonedDateTime.format(zoneAbbreviationFormatter);
        return formattedDateTime+" "+currentAbbreviation;
    }
}
