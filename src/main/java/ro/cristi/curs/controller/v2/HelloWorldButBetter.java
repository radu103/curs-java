package ro.cristi.curs.controller.v2;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.cristi.curs.dto.HelloResponseButBetter;

@RestController
@RequestMapping("/v2")
public class HelloWorldButBetter {

    @GetMapping(path = "/lista/limbaje")
    public String getLimbaje(){
        ArrayList<String> listaLimbaje = new ArrayList<String>(){
            {
            add("Java");
            add("C++");
            add("Python");
            add("N-am avut inspiratie");
            }
        };
        return listaLimbaje.toString();
    }
    

    @GetMapping(path = "/lista/jocuri")
    public String getJocuri(){
        ArrayList<String> listaJocuri = new ArrayList<String>() {
            {
            add("Osu!");
            add("Genshin");
            add("Sekai");
            add("Adofai");
            }
        };
        return listaJocuri.toString();
    }

    @GetMapping(path = "/vorbe_intelepte")
    public HelloResponseButBetter responseVorba(){
        HelloResponseButBetter respo = new HelloResponseButBetter();
        respo.setMotivational("iti merge bine vere");
        respo.setDemotivational("sau poate ca nu cred ca o sa iti mearga (plangi)");
        return respo;
    }

    @PostMapping(path = "/vorbe_neintelepte", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String postHelloV2(@RequestBody HelloResponseButBetter helloRequest){
        return "Vorbele tale motivationale: " + helloRequest.getMotivational() +  "\nSi alea demotivationale: " + helloRequest.getDemotivational();
    }
    
}
