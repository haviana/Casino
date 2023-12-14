package com.gthsoftware.casino.user;

import com.gthsoftware.casino.response.APIResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserDao userRepository;

    UserService userService;
    @Test
    public void test(){


        User user = new User();
        user.setLastName("LastName");
        user.setFirstName("FirstName");
        user.setEmail("hugo@gmail.com");

//        when(userRepository.findById(1l)).thenReturn(Optional.of(user));

//        APIResponse<UserDTO> response = userService.getUser(1l);



//        Assertions.assertSame("FirstName", user.getFirstName());
//        Assertions.assertSame("LastName", user.getLastName());
    }

}
