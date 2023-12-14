package com.gthsoftware.casino.user;

import com.gthsoftware.casino.response.APIResponse;
import com.gthsoftware.casino.utils.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserDao userRepository;

    private final UserDTOMapper userDTOMapper;

    private final UserMapper userMapper;

    public UserService(UserDao userRepository, UserDTOMapper userDTOMapper, UserMapper userapper) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
        this.userMapper = userapper;
    }

    public APIResponse<UserDTO> getUser(Long id) {

        if (this.userRepository.findById(id).isEmpty()) {
            return APIResponse.notFound(null, Constant.getUserResponseHashMap(), Constant.USER_RESPONSE_CODE_PREFIX.concat("1"));
        }

        User user = this.userRepository.findById(id).get();
        UserDTO userDto = this.userDTOMapper.apply(user);
        return APIResponse.ok(userDto, Constant.getUserResponseHashMap(), StringUtils.join(Constant.USER_RESPONSE_CODE_PREFIX, "6"));
    }

    public APIResponse<List<UserDTO>> getAllUsers() {

        List<User> userList = this.userRepository.findAll();

        List<UserDTO> usersDTOs = userList.stream()
                .map(this.userDTOMapper)
                .toList();
        return APIResponse.ok(usersDTOs, Constant.getUserResponseHashMap(), Constant.USER_RESPONSE_CODE_PREFIX.concat("2"));
    }

    public APIResponse<UserDTO> createUser(UserDTO userDTO) {

        User user = this.userMapper.apply(userDTO);

        user = this.userRepository.save(user);

        return APIResponse.ok(userDTOMapper.apply(user), Constant.getUserResponseHashMap(), Constant.USER_RESPONSE_CODE_PREFIX.concat("7"));
    }

    public APIResponse<UserDTO> deleteById(UserDTO userDTO) {

        User user = userMapper.apply(userDTO);

        if (this.userRepository.findById(user.getId()).isEmpty()) {
            return APIResponse.notFound(userDTO, Constant.getUserResponseHashMap(), StringUtils.join(Constant.USER_RESPONSE_CODE_PREFIX, "5"));

        }
        this.userRepository.deleteById(user.getId());
        return APIResponse.ok(userDTO, Constant.getUserResponseHashMap(), StringUtils.join(Constant.USER_RESPONSE_CODE_PREFIX, "9"));
    }

}
