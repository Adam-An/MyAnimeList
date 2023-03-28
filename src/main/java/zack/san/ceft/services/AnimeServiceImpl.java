package zack.san.ceft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zack.san.ceft.entities.Anime;
import zack.san.ceft.repositories.AnimeRepository;

import java.util.List;

//why we use service annotation
@Service
public class AnimeServiceImpl  implements AnimeService{

    private final AnimeRepository animeRepository;

    @Autowired
    public AnimeServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public Anime save(Anime anime) {
        return animeRepository.save(anime);
    }

    @Override
    public List<Anime> findAll() {
        return animeRepository.findAll();
    }

    @Override
    public Anime findById(Integer id) {
        return animeRepository.findAnimeById(id);
    }

    @Override
    public Anime update(Anime anime) {


        return animeRepository.save(anime);
    }

    @Override
    public void delete(Integer id) {

        animeRepository.deleteById(id);

    }
}
