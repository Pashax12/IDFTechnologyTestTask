package by.paul.idftesttask.service;

import by.paul.idftesttask.dto.UserDTO;
import by.paul.idftesttask.entity.User;

public interface UserNotifyService {

  User addUser(UserDTO userDTO);
  void notifyUser();
}
