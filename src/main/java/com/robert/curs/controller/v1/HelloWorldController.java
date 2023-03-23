package com.robert.curs.controller.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robert.curs.dto.HelloRequest;
import com.robert.curs.dto.HelloResponse;
import com.robert.curs.dto.HelloList;

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

    @GetMapping(path = "/helloworld/hello2/json", produces = { MediaType.APPLICATION_JSON_VALUE })
    public HelloList getHelloList() {

        ArrayList<String> jdm = new ArrayList<>(Arrays.asList("R34 skyline","Supra","RX7","NSX"));
        ArrayList<String> euro = new ArrayList<>(Arrays.asList("RS2","e46 M3","CLK GTR","911 GT3"));
        ArrayList<String> american = new ArrayList<>(Arrays.asList("Challanger","Mustang","Camaro"));

        HashMap<String, ArrayList<String>> a = new HashMap<String, ArrayList<String>>();
        a.put("jdm", jdm);
        a.put("euro", euro);
        a.put("american", american);

        HelloList list = new HelloList();
        list.setMaps(a);
        return list;
    }

    @PostMapping(path = "/helloworld/hello1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public String postHello1(@RequestBody HelloRequest helloRequest) {

        return "Hello World : " + helloRequest.getA();
    }
}
