package web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import web.dto.UserDto;
import web.entity.UserEntity;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity dtoToEntity(UserDto userDto);

    UserDto entityToDto(UserEntity userEntity);
}
