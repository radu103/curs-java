package ro.raffa.curs.controller.tema;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import ro.raffa.curs.dto.TemaLista;

@SpringBootTest
@AutoConfigureMockMvc
public class TemaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getLista() throws Exception {
        TemaLista temaLista=new TemaLista();
        String jsoString=objectMapper.writeValueAsString(temaLista);

        mockMvc.perform(get("/tema/listajocuri")).
        andExpect(status().isOk()).
        andExpect(content().string(jsoString));

    }
    
}
