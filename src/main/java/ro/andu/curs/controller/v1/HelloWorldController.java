package ro.andu.curs.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HelloWorldController {
    
    @GetMapping(path = "/helloworld/hello1")
    public String hello1() {
        return "Hello World";
    }

    // @PostMapping(path = "/helloworld/hello1", produces = ContentType)
    // public String postHello1() {
    //     return "Hello World POST";
    // }
}
