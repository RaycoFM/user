package com.example.managerusers.controller;


import com.example.managerusers.api.UserApi;
import com.example.managerusers.dto.PatchUserDTO;
import com.example.managerusers.dto.UserDTO;
import com.example.managerusers.dto.UserInDTO;
import com.example.managerusers.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<List<UserDTO>> users() {
        return new ResponseEntity<>(userService.users(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> userById(BigDecimal id) {
        return new ResponseEntity<>(userService.userById(id.longValue()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(BigDecimal id, UserInDTO userInDTO) {
        return new ResponseEntity<>(userService.updateUser(id.longValue(), userInDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> patchUser(BigDecimal id, PatchUserDTO userPatchDTO) {
        return new ResponseEntity<>(userService.patchUser(id.longValue(), userPatchDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> saveUser(UserInDTO userInDTO) {
        return new ResponseEntity<>(userService.saveUser(userInDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteUser(BigDecimal id) {
        userService.deleteUser(id.longValue());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getUser")
    public ResponseEntity<List<UserDTO>> getUser() {
        return new ResponseEntity<>(userService.users(), HttpStatus.OK);
    }
}
