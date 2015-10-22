package com.adam.fizzbuzz.web;

import com.adam.fizzbuzz.service.FizzBuzzService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class FizzBuzzControllerTest {
    @Mock
    private FizzBuzzService service;


    @Test
    public void testHomePage() throws Exception {
        FizzBuzzController controller = new FizzBuzzController(service);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/")).andExpect(view().name("index"));
    }


    @Test
    public void testCalculate() throws Exception {
        String dataArg = "1 2 3";

        FizzBuzzController controller = new FizzBuzzController(service);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/").param("data", dataArg)).andExpect(view().name("index"));
        verify(service).solveFizzBuzz(dataArg);
    }

}
