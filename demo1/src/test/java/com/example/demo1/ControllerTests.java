package com.example.demo1;

import com.example.demo1.service.DemoService;
import com.example.demo1.service.DemoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ControllerTests {
    @Test
    void testLocalTime() {
        // Create an instance of your service
        DemoService demoService = new DemoServiceImpl();

        // Call the localTime() method
        String result = demoService.localTime();

        // Assert that the result is not null
        assertNotNull(result);

        // Expected format: "dd-MM-yyyy HH:mm:ss zzz"
        assertTrue( result.matches("\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}:\\d{2} [A-Z]{3}"));
    }
}
