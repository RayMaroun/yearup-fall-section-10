package com.pluralsight.demoapi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // This annotation indicates that the class serves RESTful web requests.
public class HomeController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(@RequestParam(defaultValue = "World") String name) {
        // This method handles GET requests to the root URL ("/").
        // It returns a greeting message. If no name is provided, it defaults to "World".
        return "Hello " + name + "!";
    }
}
