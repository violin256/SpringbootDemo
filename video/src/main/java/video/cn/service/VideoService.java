package video.cn.service;

import org.springframework.data.domain.Page;
import video.cn.pojo.VideoInfo;

import java.util.List;
import java.util.Map;

public interface VideoService {
    //查询视频信息
    public Page<VideoInfo> findAll(int page,int size,String type);
    //查询视频信息
    public Page<VideoInfo> findAll2(int page,int size,String type);
    //查询最后一页数据
    public List<VideoInfo> findEndPage(int page,int size,String type);
    //搜索视频
    public Page<VideoInfo> findAllByVname(int page,int size,String type);
    //视频详情
    public  List<VideoInfo> findByVname(String vname);
    //查询历史记录
    public  List<Map<String, Object>> findByUname(String uname);
    //查询下载记录
    public  List<Map<String, Object>> findDownloadByUname(String uname);
    //查询收藏记录
    public  List<Map<String, Object>> findFavorByUname(String uname);
}
