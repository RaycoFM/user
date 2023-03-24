package com.example.managerusers.service;


import com.example.managerusers.dto.PatchUserDTO;
import com.example.managerusers.dto.UserDTO;
import com.example.managerusers.dto.UserInDTO;
import com.example.managerusers.mapper.UserMapper;
import com.example.managerusers.models.User;
import com.example.managerusers.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> users() {
        return this.userRepository.findAll().stream()
                .map(this.userMapper::asUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO userById(Long id) {
        Optional<UserDTO> user = this.userRepository.findById(id).stream()
                .map(this.userMapper::asUserDTO).findFirst();

        return user.orElseGet(UserDTO::new);

    }

    @Override
    public UserDTO updateUser(Long id, UserInDTO userInDTO) {

        User userUpdate = this.userMapper.asUserIdInDTO(id, userInDTO);
        User user = this.userRepository.save(userUpdate);
        return this.userMapper.asUserDTO(user);

    }

    /*
    @Override
    public UserDTO patchUser(Long id, PatchUserDTO userPatchDTO) {

        //User userUpdate = this.userMapper.asUserIdPatchDTO(id, userPatchDTO);
        User userBD = this.userRepository.findById(id).stream().findFirst().orElseGet(User::new);
        User userUpdate = this.userMapper.asUserIdPatchDTO(id, userPatchDTO);

        User user = this.userRepository.save(userUpdate);
        return this.userMapper.asUserDTO(user);

    }*/

    @Override
    public UserDTO patchUser(Long id, PatchUserDTO userPatchDTO) {
        User userBD = this.userRepository.findById(id).stream().findFirst().orElseGet(User::new);

        /*if(userPatchDTO.getEmail()!=null)
            userBD.setEmail(userPatchDTO.getEmail());
        if(userPatchDTO.getName()!=null)
            userBD.setName(userPatchDTO.getName());
        if(userPatchDTO.getPriority()!=null)
            userBD.setPriority(userPatchDTO.getPriority());*/

        User user = this.userMapper.updateUser(userBD, userPatchDTO);

        return this.userMapper.asUserDTO(this.userRepository.save(user));

    }

    @Override
    public UserDTO saveUser(UserInDTO userInDTO) {

        User userInsert = this.userMapper.asUser(userInDTO);
        User user = this.userRepository.save(userInsert);
        return this.userMapper.asUserDTO(user);

    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }


}


