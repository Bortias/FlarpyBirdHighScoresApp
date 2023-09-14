package web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dto.HighscoreDto;
import web.mapper.HighscoreMapper;
import web.repository.HighscoreRepository;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class HighscoreServiceImpl implements HighscoreService{

    @Autowired
    HighscoreRepository highscoreRepository;

//    @Autowired
//    HighscoreMapper mapper;

    public List<HighscoreDto> getAllHighscores(){
        return HighscoreMapper.INSTANCE.entityToDto(highscoreRepository.findByOrderByValueDesc());
    }

    public HighscoreDto saveHighscore(HighscoreDto dto){
        return HighscoreMapper.INSTANCE.entityToDto(highscoreRepository.save(HighscoreMapper.INSTANCE.dtoToEntity(dto)));
    }

    public boolean deleteHighscore(UUID highscoreId){
        try{
            highscoreRepository.deleteById(highscoreId);
            return true;
        }catch(Exception e){
            log.error(e.getLocalizedMessage());
            return false;
        }
    }
}
