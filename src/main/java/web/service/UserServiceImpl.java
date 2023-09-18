package web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dto.UserDto;
import web.exceptions.UserNotCreatedException;
import web.exceptions.UserNotFoundException;
import web.mapper.UserMapper;
import web.repository.UserRepository;

import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    //TODO: make a cascading exception catches (wrongUserParameters -> userCreatedFound)
    @Override
    public UserDto createUser(UserDto userDto) throws UserNotCreatedException {
        try {
            userRepository.save(UserMapper.INSTANCE.dtoToEntity(userDto));
        } catch (Exception e) {
            throw new UserNotCreatedException(e.getMessage());
        }
        return null;
    }

    @Override
    public UserDto getUser(String loginString, String password) throws UserNotFoundException {
        if (checkIfEmail(loginString)) {
            try {
                return UserMapper.INSTANCE.entityToDto(userRepository.findByEmailAndPassword(loginString, password));
            } catch (Exception e) {
                throw new UserNotFoundException(e.getMessage());
            }
        } else {
            try {
                return UserMapper.INSTANCE.entityToDto(userRepository.findByNameAndPassword(loginString, password));
            } catch (Exception e) {
                throw new UserNotFoundException(e.getMessage());
            }
        }
    }

    //TODO: make a cascading exception catches (wrongUserParameters -> userNotFound)
    @Override
    public UserDto updateUser(UserDto userDto) throws UserNotFoundException {
        try {
            return UserMapper.INSTANCE.entityToDto(userRepository.save(UserMapper.INSTANCE.dtoToEntity(userDto)));
        } catch (Exception e) {
            throw new UserNotFoundException(e.getMessage());
        }
    }

    @Override
    public void deleteUser(UUID userId) throws UserNotFoundException {
        try {
            if (userRepository.findById(userId).isPresent()) {
                userRepository.deleteById(userId);
            }
        } catch (Exception e) {
            throw new UserNotFoundException(e.getMessage());
        }
    }

    private boolean checkIfEmail(String loginString) {
        return loginString.contains("@") && loginString.contains(".");
    }
}
