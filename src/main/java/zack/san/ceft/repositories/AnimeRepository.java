package zack.san.ceft.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zack.san.ceft.entities.Anime;


@Repository
public interface AnimeRepository extends JpaRepository<Anime,Integer> {

 Anime findAnimeById(Integer id);

}
