package com.example.demo1;

import com.example.demo1.service.DemoService;
import com.example.demo1.service.DemoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DemoServiceTests {

    @Test
    void testLocalTimeMethod() {
        // Create an instance of your service
        DemoService demoService = new DemoServiceImpl();

        // Call the localTime() method
        String result = demoService.localTime();

        // Assert that the result is not null
        assertNotNull(result);

        // Expected format: "dd-MM-yyyy HH:mm:ss zzz"
        assertTrue( result.matches("\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2} [A-Z]{3}"));
    }
    @Test
    void testLocalTime() {

        LocalDate currentDate=LocalDate.now();
        // Assert the currentDate is not null
        assertNotNull(currentDate);

        LocalTime currentTime=LocalTime.now();
        // Assert the currentTime is not null
        assertNotNull(currentTime);

        ZoneId myZone= ZoneId.systemDefault();
        // Assert the myZone is not null
        assertNotNull(myZone);

        ZonedDateTime zonedDateTime=ZonedDateTime.of(currentDate,currentTime,myZone);
        // Assert the zoneDateTime is not null
        assertNotNull(zonedDateTime);


        DateTimeFormatter zoneAbbreviationFormatter = DateTimeFormatter.ofPattern("zzz", Locale.ENGLISH);
        String currentAbbreviation = zonedDateTime.format(zoneAbbreviationFormatter);
        // Assert the zone abbreviation is not null
        assertNotNull(currentAbbreviation);
        // Assert that currentAbbreviation matches the format
        assertTrue(currentAbbreviation.matches("[A-Z]{3}"));

        LocalDateTime currentDateTime=LocalDateTime.now();
        // Assert that the current date and time is not null
        assertNotNull(currentDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String result = currentDateTime.format(formatter);
        // Assert that the result is not null
        assertNotNull(result);
        // Expected format: "dd-MM-yyyy HH:mm:ss zzz"
        assertTrue( result.matches("\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2}"));
    }


}

