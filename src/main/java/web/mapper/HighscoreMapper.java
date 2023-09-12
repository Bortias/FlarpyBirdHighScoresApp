package web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import web.dto.HighscoreDto;
import web.entity.HighscoreEntity;

@Mapper
public interface HighscoreMapper {
    HighscoreMapper INSTANCE = Mappers.getMapper(HighscoreMapper.class);

    HighscoreEntity dtoToEntity(HighscoreDto highscoreDto);

    HighscoreDto entityToDto(HighscoreEntity highscoreEntity);
}
