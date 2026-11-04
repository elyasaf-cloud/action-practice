package com.example.cicdpractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CicdPracticeApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Sanity test: 4 == 4")
    void testSanityCalculation() {
        int expected = 4;
        int actual = 2 + 3;
        assertEquals(expected, actual, "2 + 2 must equal 4");
    }

    @Test
    @DisplayName("Spring Application Context loads successfully")
    void contextLoads() {
        // Confirms the Spring Boot application starts without errors
    }

    @Test
    @DisplayName("GameController forwards root path '/' to index.html")
    void testHomePageController() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/index.html"));
    }
}
