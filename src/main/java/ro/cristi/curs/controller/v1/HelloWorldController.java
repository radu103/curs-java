package ro.cristi.curs.controller.v1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.cristi.curs.dto.HelloRequest;


@RestController
@RequestMapping("/v1")
public class HelloWorldController {

    @GetMapping(path = "/helloworld/hello")
    public String getHello() {
        return "Hello World";
    }
    @GetMapping(path = "/helloworld/morning")
    public String getNeata() {
        return "Neata lume";
    }
    
    @PostMapping(path = "/helloworld/hello", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String postHello(@RequestBody HelloRequest helloRequest){
        return "Hello World : " + helloRequest.getInput();
    }
}
 