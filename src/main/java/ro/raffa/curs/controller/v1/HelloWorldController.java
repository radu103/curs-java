package ro.raffa.curs.controller.v1;

import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.raffa.curs.dto.HelloRequest;

@RestController
@RequestMapping("/v1")
@Profile("local")
public class HelloWorldController {

    @GetMapping(path = "/helloworld/hello1")
    public String getHello1() {
        return "Hello World";
    }

    @PostMapping(path = "/helloworld/hello1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public String postHello1(@RequestBody HelloRequest helloRequest) {
        return "Hello World : " + helloRequest.getInput();
    }
}
