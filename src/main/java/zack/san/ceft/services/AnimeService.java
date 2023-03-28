package zack.san.ceft.services;

import zack.san.ceft.entities.Anime;

import java.util.List;

public interface AnimeService {

    Anime save(Anime anime);

    List<Anime> findAll();


    Anime findById(Integer id);

    Anime update(Anime anime);

    void delete(Integer id);

}
