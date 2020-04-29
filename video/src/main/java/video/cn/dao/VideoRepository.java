package video.cn.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import video.cn.pojo.UserInfo;
import video.cn.pojo.VideoInfo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public interface VideoRepository extends JpaRepository<VideoInfo,Integer>, JpaSpecificationExecutor<VideoInfo> {

    @Query(value = "select * from videos where vno in (" +
            "select ttypes.vno from ttypes where typename = ?1)",nativeQuery = true)
    public Page<VideoInfo> findByVno(Pageable pageable,  String type);
    //最后一页数据
    @Query(value = "select * from videos where vno in (" +
            "select ttypes.vno from ttypes where typename = ?1)" +
            " order by vno ASC limit ?2,?3",nativeQuery = true)
    public List<VideoInfo> findByType( String type,int start,int size);

    //查询历史记录
    @Query(value = "select  new map(list.vname,list.vurl,list.details," +
            "list2.hno,list2.hdates) " +
            "from videos list,historys list2 " +
            " where  list2.uname = ?1 and list.vname=list2.fname ",nativeQuery = false)
    List<Map<String, Object>> findByUname(String uname);

    //查询下载记录
    @Query(value = "select  new map(list.vname,list.vurl,list.details," +
            "list2.dno,list2.counts) " +
            "from videos list,download list2 " +
            " where  list2.uname = ?1 and list.vname=list2.vname ",nativeQuery = false)
    List<Map<String, Object>> findDownloadByUname(String uname);
    //查询收藏记录
    @Query(value = "select  new map(list.vname,list.vurl,list.details,list2.fno) " +
            " from videos list,favorites list2 " +
            " where  list2.uname = ?1 and list.vname=list2.fname ",nativeQuery = false)
    List<Map<String, Object>> findFavorByUname(String uname);

}
