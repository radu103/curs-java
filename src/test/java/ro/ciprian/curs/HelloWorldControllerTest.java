package ro.ciprian.curs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import ro.ciprian.curs.dto.HelloRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGet() throws Exception{
        mockMvc.perform(get("/v1/helloworld/hello1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));

        assertTrue(true);
    }

    @Test
    void testPost() throws Exception{
        HelloRequest req = new HelloRequest();
        req.setA("valoare lui a");
        req.setB("valoare lui b");

        String reqJson = objectMapper.writeValueAsString(req);

        mockMvc.perform(post("/v1/helloworld/hello1").contentType(MediaType.APPLICATION_JSON).content(reqJson))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World : " + req.getA()));

        String payload = "{\"a\":\"valoare a\", \"b\":\"valoare b\"}";
        mockMvc.perform(post("/v1/helloworld/hello1").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World : valoare a"));


        assertTrue(true);
    }
}