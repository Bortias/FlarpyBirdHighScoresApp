package web.service;

import web.dto.UserDto;
import web.exceptions.UserNotCreatedException;
import web.exceptions.UserNotFoundException;

import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto userDto) throws UserNotCreatedException;

    UserDto getUser(String loginString, String password) throws UserNotFoundException;

    UserDto updateUser(UserDto userDto) throws UserNotFoundException;

    void deleteUser(UUID userId) throws UserNotFoundException;

}
