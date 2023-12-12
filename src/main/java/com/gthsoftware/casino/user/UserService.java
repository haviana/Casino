package com.gthsoftware.casino.user;

import com.gthsoftware.casino.response.APIResponse;
import com.gthsoftware.casino.utils.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    UserDao userRepository;

    public UserService(UserDao userRepository) {
        this.userRepository = userRepository;
    }

    public APIResponse<UserDTO> getUser(Long id){


         if (this.userRepository.findById(id).isPresent()){
             User user = this.userRepository.findById(id).get();
             UserDTO userDto = UserDTO.builder().id(user.getId()).dateOfBirth(user.dateOfBirth).firstName(user.firstName).email(user.email).lastName(user.lastName).build();

             return APIResponse.ok(userDto,Constant.getUserResponseHashMap(), StringUtils.join(Constant.USER_RESPONSE_CODE_PREFIX,"6"));
         }else {
             return APIResponse.notFound(null,Constant.getUserResponseHashMap(), Constant.USER_RESPONSE_CODE_PREFIX.concat("1"));
         }

    }

    public APIResponse<List<UserDTO>> getUsers(){

        List<User> userList = this.userRepository.findAll();

        List<UserDTO> usersDtos = userList.stream()
                .map(x-> UserDTO.builder()
                        .id(x.getId())
                        .lastName(x.lastName)
                        .firstName(x.firstName)
                        .email(x.email)
                        .dateOfBirth(x.dateOfBirth)
                        .build())
                .toList();
        return APIResponse.ok(usersDtos,Constant.getUserResponseHashMap(),Constant.USER_RESPONSE_CODE_PREFIX.concat("2"));
    }

    public APIResponse<UserDTO> createUser(UserDTO userDTO){

        User user = User.builder()
                .email(userDTO.email)
                .firstName(userDTO.firstName)
                .dateOfBirth(userDTO.dateOfBirth)
                .lastName(userDTO.lastName).build();

        user = this.userRepository.save(user);

        userDTO = UserDTO.builder()
                .firstName(user.firstName)
                .lastName(user.lastName)
                .id(user.getId())
                .email(user.email)
                .build();

        return APIResponse.ok(userDTO, Constant.getUserResponseHashMap(),Constant.USER_RESPONSE_CODE_PREFIX.concat("7"));
    }

    public APIResponse<UserDTO> deleteById(UserDTO userDTO){

        User user = User.builder()
                .id(userDTO.id)
                .dateOfBirth(userDTO.dateOfBirth)
                .firstName(userDTO.firstName)
                .lastName(userDTO.lastName)
                .email(userDTO.email).build();

        if (this.userRepository.findById(user.getId()).isPresent()){
            this.userRepository.deleteById(user.getId());
            return APIResponse.ok(userDTO,Constant.getUserResponseHashMap(), StringUtils.join(Constant.USER_RESPONSE_CODE_PREFIX,"9"));
        }
        return APIResponse.notFound(userDTO,Constant.getUserResponseHashMap(), StringUtils.join(Constant.USER_RESPONSE_CODE_PREFIX,"5"));
    }
}
