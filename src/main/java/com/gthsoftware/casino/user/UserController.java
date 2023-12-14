package com.gthsoftware.casino.user;

import com.gthsoftware.casino.response.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    public UserController(UserService userService) {
        this.userService = userService;
    }

    UserService userService;

    @GetMapping(value = "{id}")
    @Operation(summary = "Gets User by ID",
            description= "User must exist")
    ResponseEntity<APIResponse<UserDTO>> getUser(@PathVariable Long id){

        APIResponse<UserDTO> response = userService.getUser(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);

    }

    @GetMapping
    @Operation(summary = "Gets all the Users")
    ResponseEntity<APIResponse<List<UserDTO>>> getUsers(){
        APIResponse<List<UserDTO>> response = userService.getAllUsers();
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping
    @Operation(summary = "Creates an User")
    ResponseEntity<APIResponse<UserDTO>> createUser(UserDTO userCreate){

        APIResponse<UserDTO> userDTO =userService.createUser(userCreate);

        return ResponseEntity
                .status(userDTO.getHttpStatus())
                .body(userDTO);

    }

    @DeleteMapping
    @Operation(summary = "Delete an User by ID")
    ResponseEntity<APIResponse<UserDTO>> deleteUser(UserDTO userCreate){
        APIResponse<UserDTO> userDTO =userService.deleteById(userCreate);

        return ResponseEntity
                .status(userDTO.getHttpStatus())
                .body(userDTO);
    }

}
