package ro.andu.curs.controller.v1;

import java.util.ArrayList;

import javax.print.attribute.standard.Media;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.andu.curs.dto.HelloRequest;
import ro.andu.curs.dto.HelloResponse;
import ro.andu.curs.dto.HelloResponseList;

@RestController
@RequestMapping("/v1")
public class HelloWorldController {
    
    @GetMapping(path = "/helloworld/hello1")
    public String hello1() {
        return "Hello World";
    }

    @GetMapping(path = "/helloworld/hello1/json", produces = {MediaType.APPLICATION_JSON_VALUE})
    public HelloResponse postHello1Json() {
        HelloResponse resp = new HelloResponse();
        resp.setA("AA");
        resp.setB("BB");
        return resp;
    }

    @GetMapping(path = "/helloworld/hello2/json", produces = {MediaType.APPLICATION_JSON_VALUE})
    public HelloResponseList postHello2Json() {
        HelloResponseList resp = new HelloResponseList();
        ArrayList<String> a = new ArrayList<>();
        a.add("test");
        a.add("test2");
        a.add("test3");
        resp.setA(a);
        return resp;
    }

    @PostMapping(path = "/helloworld/hello1", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {
        MediaType.APPLICATION_JSON_VALUE})
    public String postHello1(@RequestBody HelloRequest helloRequest) {
        return "Hello World : " + helloRequest.getA();
    }
    
}
