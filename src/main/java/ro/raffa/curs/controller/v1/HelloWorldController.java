package ro.raffa.curs.controller.v1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import ro.raffa.curs.dto.HelloRequest;
import ro.raffa.curs.dto.HelloResponse;

@RestController
@RequestMapping ("/v1")
public class HelloWorldController {
    
    @GetMapping(path ="/helloworld/hello1")
    public String getHello1() {
        return "Hello World";
    } 

     
    @GetMapping(path ="/helloworld/hello1/json",produces= {MediaType.APPLICATION_JSON_VALUE})
    public HelloResponse  getHello1Json(){
        HelloResponse resp=new HelloResponse();
        resp.setA("AA");
        resp.setB("BB");
        return resp;
    }

    @PostMapping(path = "/helloworld/hello1", consumes = { MediaType.APPLICATION_JSON_VALUE }, 
    produces = {MediaType.APPLICATION_JSON_VALUE })
    public String postHello1(@RequestBody HelloRequest helloRequest) {
    return "Hello World : " + helloRequest.getA();
}


}

    //e de test

    // DELETE e delete
    // PUT = update integral
    //POST = creeaza ceva nou
    //PATCH= update partial
   /*  
   
    ASTEA POT FI IGNORATE. OLD STUFF :)    

    @PostMapping (path ="/helloworld/hello1", 
    consumes={MediaType.APPLICATION_JSON_VALUE},
    produces={MediaType.APPLICATION_JSON_VALUE})
    public String postHello1(@RequestBody String input) {
        return "Hello World Post : " + input;
    }
*/


  /*  
    @GetMapping 
    public String hello2() {
        return "BYEBYE WORLD";
    }

    //aici da eroare, pentru ca,  
    // daca lasi doua @GetMapping-uri fara path,
    // programul incearca sa mearga pe /v1,
    // care e la @RequestMapping
    // dar, fiind doua @GetMapping fara path, 
    // ele intra in conflict si da eroare la build :)
    
    @GetMapping
    public String hello3() {
        return "Is there a conflict?";
    }
    
    */ 

