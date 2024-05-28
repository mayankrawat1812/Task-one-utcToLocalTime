package com.example.demo1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo1.service.DemoService;

@RestController
@RequestMapping("/api")
public class Controller {
   @Autowired
    DemoService service;
    @GetMapping("/localDate")
    public String localTime(){
        return service.localTime();
    }
}
