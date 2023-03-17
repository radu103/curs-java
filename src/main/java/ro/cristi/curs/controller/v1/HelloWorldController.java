package ro.cristi.curs.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.cristi.curs.dto.HelloRequest;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/v1")
public class HelloWorldController {

    @GetMapping(path = "/helloworld/hello1")
    public String getHello1(){
        return "Hello World";
    }
    @PostMapping(path = "/helloworld/hello1")
    public String postHello1(HelloRequest helloRequest){
        return "Hello World : " + helloRequest.getA();
    }
    
}
