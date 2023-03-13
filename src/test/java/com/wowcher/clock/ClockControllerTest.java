package com.wowcher.clock;

import com.wowcher.clock.controller.ClockController;
import com.wowcher.clock.service.ClockService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ClockControllerTest {

    @InjectMocks
    ClockController clockController;

    @Mock
    ClockService clockService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void testConvertTime() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/clock/convert?time=08:55")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("It's eight fifty five"));

        mockMvc.perform(MockMvcRequestBuilders.get("/clock/convert?time=00:00")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("It's Midnight"));

        mockMvc.perform(MockMvcRequestBuilders.get("/clock/convert?time=12:00")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("It's Midday"));

        mockMvc.perform(MockMvcRequestBuilders.get("/clock/convert?time=23:55")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("It's twenty three fifty five"));

        mockMvc.perform(MockMvcRequestBuilders.get("/clock/convert?time=abcd:efcg")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        mockMvc.perform(MockMvcRequestBuilders.get("/clock/convert?time=-01:67")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        mockMvc.perform(MockMvcRequestBuilders.get("/clock/convert?time=-01:67:57")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        mockMvc.perform(MockMvcRequestBuilders.get("/clock/convert?time=-01:67")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }
}
