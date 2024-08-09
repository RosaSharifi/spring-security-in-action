package com.example.portalsecurity.controller.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //start 8.1
    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/ciao")
    public String ciao() {
        return "Ciao!";
    }

    @GetMapping("/hola")
    public String hola() {
        return "Hola!";
    }
    //end 8.1

    //start 8.2
    @PostMapping("/a")
    public String postEndpointA() {
        return "Works!";
    }

    @GetMapping("/a")
    public String getEndpointA() {
        return "Works!";
    }

    @GetMapping("/a/b")
    public String getEnpointB() {
        return "Works!";
    }

    @GetMapping("/a/b/c")
    public String getEnpointC() {
        return "Works!";
    }

    @GetMapping("/product/{code}")
    public String productCode(@PathVariable String code) {
        return code;
    }
    //end 8.2

    //start 8.3
    @GetMapping("/video/{country}/{language}")
    public String video(@PathVariable String country,
                        @PathVariable String language) {
        return "Video allowed for " + country + " " + language;
    }
    //end 8.3

}