package ro.raffa.curs.controller.tema;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ro.raffa.curs.dto.TemaLista;



@RestController
@RequestMapping("/tema")
public class TemaController {

    @GetMapping(path="/listajocuri", produces={MediaType.APPLICATION_JSON_VALUE})
    private TemaLista getLista() {
        TemaLista lista=new TemaLista();

        return lista;

    }
    
}
