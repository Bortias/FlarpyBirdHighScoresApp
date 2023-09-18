package web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.dto.UserDto;
import web.exceptions.UserNotCreatedException;
import web.exceptions.UserNotFoundException;
import web.service.UserServiceImpl;

import java.util.UUID;

@RestController
@Slf4j
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping(name = "/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) throws UserNotCreatedException {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @GetMapping(name = "/user")
    public ResponseEntity<UserDto> getUser(@RequestParam String loginString, @RequestParam String password) throws UserNotFoundException {
        return ResponseEntity.ok(userService.getUser(loginString, password));
    }

    @PutMapping(name = "/user")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) throws UserNotFoundException {
        return ResponseEntity.ok(userService.updateUser(userDto));
    }

    @DeleteMapping(name = "/user")
    public ResponseEntity<String> deleteUser(@RequestParam UUID password) throws UserNotFoundException {
        userService.deleteUser(password);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
