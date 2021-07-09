package com.discussion.community.controller;

import com.discussion.community.model.User;
import com.discussion.community.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class UserControllerTest {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Mock
    UserService userService;

    @Test
    void mockTest() {
        List<String> list = new ArrayList<>();
        list.get(0);
        List mockedList = mock(List.class);
        mockedList.add("one");

        when(mockedList.get(0)).thenReturn("one");

        System.out.println(mockedList.get(0));

        verify(mockedList).add(anyString());
    }

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void addUser() {
        User user = new User.Builder("zhang").password("123").build();
        user.setName("zhang");
        user.setPassword("123");
        ObjectMapper mapper = new ObjectMapper();
        try {
            String s = mapper.writeValueAsString(user);
            mockMvc.perform(MockMvcRequestBuilders
                    .post("/user")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(s)
            ).andExpect(MockMvcResultMatchers.status().is2xxSuccessful()).andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void name() {
        User user = new User.Builder("zhang").password("123").build();
        when(userService.addUser(user)).thenReturn("ok " + user.getName());

        userService.addUser(user);

        verify(userService).addUser(user);
    }
}