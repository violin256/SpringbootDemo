package video.cn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import video.cn.pojo.Feedback;
import video.cn.pojo.VideoInfo;
@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
}
