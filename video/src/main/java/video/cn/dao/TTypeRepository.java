package video.cn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import video.cn.pojo.TtypesInfo;
import video.cn.pojo.VideoInfo;

import java.util.List;

@Repository
public interface TTypeRepository extends JpaRepository<TtypesInfo,Integer>, JpaSpecificationExecutor<TtypesInfo> {
    @Query(value = "select vno from ttypes where typename=?1",nativeQuery = true)
    public List<Integer> findByTypename(String typename);
    //public List<TtypesInfo> findByTypename(String typename);
}
