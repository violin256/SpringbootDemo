package video.cn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import video.cn.pojo.Favorites;
import video.cn.pojo.Feedback;
@Repository
public interface FavoritesRepository extends JpaRepository<Favorites,Integer> {
}
