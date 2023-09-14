package web.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import web.dto.HighscoreDto;
import web.entity.HighscoreEntity;

import java.util.List;

@Mapper
public interface HighscoreMapper {
    HighscoreMapper INSTANCE = Mappers.getMapper(HighscoreMapper.class);

    HighscoreEntity dtoToEntity(HighscoreDto highscoreDto);

    HighscoreDto entityToDto(HighscoreEntity highscoreEntity);

    List<HighscoreDto> entityToDto(List<HighscoreEntity> highscoreEntity);

}
