package by.paul.idftesttask;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import by.paul.idftesttask.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserNotifyControllerTest {
  @Autowired
  private MockMvc mockMvc;
  private static UserDTO userDTO;

  @BeforeAll
  static void createTestInstances(){
    userDTO =  new UserDTO();
    userDTO.setCurrencyCode(80L);
    userDTO.setEmail("etest1@gmail.com");
    userDTO.setUsername("ntest1");
  }

  @Test
  @SneakyThrows
  void addCorrectUserData() {
    this.mockMvc.perform(post("/user/notify")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(userDTO)))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.username").value("ntest1"))
        .andDo(print());
  }
  @Test
  @SneakyThrows
  void addIncorrectUserData() {
    userDTO.setCurrencyCode(-1L);
    this.mockMvc.perform(post("/user/notify")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(userDTO)))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN_VALUE))
        .andDo(print());
  }
}
