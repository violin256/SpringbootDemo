package video.cn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import video.cn.pojo.UserInfo;

import java.util.List;

@Repository
public interface  UserRepository extends JpaRepository< UserInfo,Integer>, JpaSpecificationExecutor<UserInfo> {
    public List<UserInfo> findByEmails(String emails);
}
