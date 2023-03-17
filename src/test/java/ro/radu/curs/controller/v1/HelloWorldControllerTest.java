package ro.radu.curs.controller.v1;

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

import ro.radu.curs.dto.HelloRequest;
import ro.radu.curs.dto.HelloResponse;

@SpringBootTest
@AutoConfigureMockMvc
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testA_get() throws Exception {
        mockMvc.perform(get("/v1/helloworld/hello1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void testA_get_json() throws Exception {
        HelloResponse resp = new HelloResponse();
        resp.setA("AA");
        resp.setB("BB");
        String respJson = objectMapper.writeValueAsString(resp);
        mockMvc.perform(get("/v1/helloworld/hello1/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(respJson));
    }

    @Test
    void testA_post() throws Exception {
        HelloRequest req = new HelloRequest();
        req.setA("valoarea lui a");
        req.setB("valoarea lui b");

        String reqJson = objectMapper.writeValueAsString(req);
        // mockMvc.perform(post("/v1/helloworld/hello1").contentType(MediaType.APPLICATION_JSON).content(reqJson))
        // .andExpect(status().isOk())
        // .andExpect(content().string("Hello World : " + req.getA()));

        HelloRequest req2 = new HelloRequest();
        req2.setA(req.getA() + "x");
        req2.setB(req.getB());

        String reqJson2 = objectMapper.writeValueAsString(req2);
        // mockMvc.perform(post("/v1/helloworld/hello1").contentType(MediaType.APPLICATION_JSON).content(reqJson2))
        // .andExpect(status().isOk())
        // .andExpect(content().string("Hello World : " + req2.getA()));

        sendAndExpect(reqJson, req.getA());
        sendAndExpect(reqJson2, req2.getA());
    }

    private void sendAndExpect(String body, String expectedResponse) throws Exception {
        mockMvc.perform(post("/v1/helloworld/hello1").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World : " + expectedResponse));
    }
}
