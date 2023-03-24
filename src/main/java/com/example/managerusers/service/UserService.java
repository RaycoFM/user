package com.example.managerusers.service;


import com.example.managerusers.dto.PatchUserDTO;
import com.example.managerusers.dto.UserDTO;
import com.example.managerusers.dto.UserInDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    List<UserDTO> users();

    UserDTO userById(Long id);

    UserDTO updateUser(Long id, UserInDTO userInDTO);

    UserDTO patchUser(Long id, PatchUserDTO userPatchDTO);

    UserDTO saveUser(UserInDTO userInDTO);

    void deleteUser(Long id);

}
