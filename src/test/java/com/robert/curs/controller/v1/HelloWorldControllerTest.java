package com.robert.curs.controller.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.robert.curs.dto.HelloRequest;
import com.robert.curs.dto.HelloResponse;
import com.robert.curs.dto.HelloList;
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

        ArrayList<String> jdm = new ArrayList<>(Arrays.asList("R34 skyline","Supra","RX7","NSX"));
        ArrayList<String> euro = new ArrayList<>(Arrays.asList("RS2","e46 M3","CLK GTR","911 GT3"));
        ArrayList<String> american = new ArrayList<>(Arrays.asList("Challanger","Mustang","Camaro"));

        HashMap<String, ArrayList<String>> a = new HashMap<String, ArrayList<String>>();
        a.put("jdm", jdm);
        a.put("euro", euro);
        a.put("american", american);

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


        HelloRequest req2 = new HelloRequest();
        req2.setA(req.getA() + "x");
        req2.setB(req.getB());
        String reqJson2 = objectMapper.writeValueAsString(req2);


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