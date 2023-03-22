package com.andrei.curs.controller.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.andrei.curs.dto.HelloList;
import com.andrei.curs.dto.HelloRequest;
import com.andrei.curs.dto.HelloResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    void testB_get_json() throws Exception {

        ArrayList<String> level_23 = new ArrayList<>(Arrays.asList("1 (song)", "Blessing", "ECHO"));
        ArrayList<String> level_24 = new ArrayList<>(Arrays.asList("Flyer!", "Ice Drop", "Roki", "Usseewa"));

        HashMap<String, ArrayList<String>> a = new HashMap<String, ArrayList<String>>();
        a.put("level_23", level_23);
        a.put("level_24", level_24);

        HelloList list = new HelloList();
        list.setMaps(a);
        String respJson2 = objectMapper.writeValueAsString(list);

        mockMvc.perform(get("/v1/helloworld/hello2/json"))
                .andExpect(status().isOk())
                .andExpect(content().string(respJson2));
    }

    @Test
    void testA_post() throws Exception {

        HelloRequest req = new HelloRequest();
        req.setA("valoarea lui a");
        req.setB("valoarea lui b");
        String reqJson = objectMapper.writeValueAsString(req);

        /*
         * mockMvc.perform(post("/v1/helloworld/hello1")
         * .contentType(MediaType.APPLICATION_JSON).content(reqJson))
         * .andExpect(status().isOk())
         * .andExpect(content().string("Hello World : "+req.getA()));
         */

        HelloRequest req2 = new HelloRequest();
        req2.setA(req.getA() + "x");
        req2.setB(req.getB());
        String reqJson2 = objectMapper.writeValueAsString(req2);

        /*
         * mockMvc.perform(post("/v1/helloworld/hello1")
         * .contentType(MediaType.APPLICATION_JSON).content(reqJson2))
         * .andExpect(status().isOk())
         * .andExpect(content().string("Hello World : "+req2.getA()));
         */

        sendAndExpect(reqJson, req.getA());
        sendAndExpect(reqJson2, req2.getA());
    }

    private void sendAndExpect(String body, String expectedResponse) throws Exception {
        mockMvc.perform(post("/v1/helloworld/hello1")
                .contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World : " + expectedResponse));
    }
}
