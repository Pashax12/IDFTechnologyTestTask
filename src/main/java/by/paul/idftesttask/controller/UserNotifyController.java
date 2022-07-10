package by.paul.idftesttask.controller;

import by.paul.idftesttask.dto.UserDTO;
import by.paul.idftesttask.entity.User;
import by.paul.idftesttask.service.UserNotifyService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserNotifyController {

  private final UserNotifyService userNotifyService;

  @PostMapping("/notify")
  public ResponseEntity<User> addUser(@RequestBody @Valid UserDTO userDTO) {
    return ResponseEntity.ok(userNotifyService.addUser(userDTO));
  }

}
