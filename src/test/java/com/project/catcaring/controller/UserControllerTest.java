package com.project.catcaring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.catcaring.config.auth.UserDetailService;
import com.project.catcaring.domain.User.Location;
import com.project.catcaring.dto.user.request.UserInfoRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebAppConfiguration
@WebMvcTest(UserController.class)
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper mapper;
  @Autowired
  UserDetailService userDetailService;

  @Test
  @Transactional
  @WithMockUser(value = "test10", roles = "USER")
  void signUpTest() throws Exception {
    UserInfoRequest userInfoRequest = UserInfoRequest.builder()
        .username("test10")
        .password("0000")
        .email("test10@test.com")
        .fullName("Test Ten")
        .location(Location.GANGNAM)
        .build();

    mockMvc
        .perform(post("/auth")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(userInfoRequest)))
        .andDo(print())
        .andExpect(status().isCreated());
  }

  //@Test
  @Transactional
  void duplicateIdTest() throws Exception {
    UserInfoRequest userInfoRequest = UserInfoRequest.builder()
        .username("test1")
        .password("0000")
        .email("test1@test.com")
        .fullName("Test One")
        .location(Location.GANGNAM)
        .build();

    mockMvc
        .perform(post("/auth")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(userInfoRequest)))
        .andDo(print())
        .andExpect(status().isNotFound());
  }
}
