package com.andrei.curs.controller.v1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrei.curs.dto.HelloRequest;
import com.andrei.curs.dto.HelloResponse;

@RestController
@RequestMapping("/v1")
public class HelloWorldController {

    @GetMapping(path = "/helloworld/hello1")
    public String getHello1() {
        return "Hello World";
    }

    @GetMapping(path = "/helloworld/hello2")
    public String sayHello2() {
        return "Hi traveler";
    }

    @GetMapping(path = "/helloworld/hello1/json", produces = { MediaType.APPLICATION_JSON_VALUE })
    public HelloResponse getHello1Json() {

        HelloResponse resp = new HelloResponse();
        resp.setA("AA");
        resp.setB("BB");
        return resp;
    }

    @PostMapping(path = "/helloworld/hello1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public String postHello1(@RequestBody HelloRequest helloRequest) {

        return "Hello World : " + helloRequest.getA();
    }
}
