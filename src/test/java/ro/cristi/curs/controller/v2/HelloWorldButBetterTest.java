package ro.cristi.curs.controller.v2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import ro.cristi.curs.dto.HelloRequest;
import ro.cristi.curs.dto.HelloRequestButBetter;
import ro.cristi.curs.dto.HelloResponseButBetter;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldButBetterTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testListaJocuri() throws Exception{
        ArrayList<String> listaJocuri = new ArrayList<String>() {
            {
            add("Osu!");
            add("Genshin");
            add("Sekai");
            add("Adofai");
            }
        };
        String jsonString = objectMapper.writeValueAsString(listaJocuri);
        mockMvc.perform(get("/v2/lista/jocuri"))
            .andExpect(status().isOk())
            .andExpect(content().string(jsonString));
    }

    @Test
    void testListaLimbaje() throws Exception{
        ArrayList<String> listaLimbaje = new ArrayList<String>(){
            {
            add("Java");
            add("C++");
            add("Python");
            add("N-am avut inspiratie");
            }
        };
        String jsonString = objectMapper.writeValueAsString(listaLimbaje);

        mockMvc.perform(get("/v2/lista/limbaje"))
            .andExpect(status().isOk())
            .andExpect(content().string(jsonString));
    }
    
    @Test
    void testVorbeIntelepte() throws Exception{
        HelloResponseButBetter resp = new HelloResponseButBetter();
        resp.setMotivational("iti merge bine vere");
        resp.setDemotivational("sau poate ca nu cred ca o sa iti mearga (plangi)");
        String jsonString = objectMapper.writeValueAsString(resp);

        mockMvc.perform(get("/v2/vorbe_intelepte"))
            .andExpect(status().isOk())
            .andExpect(content().string(jsonString));

    }

    @Test
    void testVorbeNeintelepte() throws Exception{
        HelloRequestButBetter req = new HelloRequestButBetter();
        req.setMotivational("da");
        req.setDemotivational("poate");
        String jsonReq = objectMapper.writeValueAsString(req);
        mockMvc.perform(post("/v2/vorbe_neintelepte")
            .contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonReq))
            .andExpect(status().isOk())
            .andExpect(content().string("Vorbele tale motivationale: " + req.getMotivational() + "\nSi alea demotivationale: " + req.getDemotivational()));
    }

}
