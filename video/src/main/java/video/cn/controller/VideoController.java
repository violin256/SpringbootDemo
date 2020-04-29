package video.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import video.cn.pojo.VideoInfo;
import video.cn.service.VideoService;

import java.util.List;

@RestController
public class VideoController {
    @Autowired
    private VideoService videoService;
    //分页显示视频信息
    @GetMapping("/VideoInfo")
    public Page<VideoInfo> VideoInfo(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "8") Integer size,
                                     @RequestParam(value = "tid") String tid,
                                     @RequestParam(value = "type") String type){
        System.out.println(tid+"type"+type);
        if(tid.equals("1")){
            System.out.println("自媒体"+type);
            return videoService.findAll(page,size,type);
        }else
             return videoService.findAll2(page,size,type);

    }
    //查询最后一页数据
    @GetMapping("/findEndPage")
    public List<VideoInfo> VideoInfo2(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "8") Integer size,
                                      @RequestParam(value = "tid") String tid,
                                      @RequestParam(value = "type") String type){
        System.out.println(page+"type"+type);
        return videoService.findEndPage(page,size,type);

    }
    //搜索视频
    @GetMapping("/searchVideo")
    public Page<VideoInfo> searchVideo(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "8") Integer size,
                                      @RequestParam(value = "type") String type){
        System.out.println(page+"type"+type);
        return videoService.findAllByVname(page,size,type);

    }
    //查询视频详情
    @GetMapping("videoDetail")
    public List<VideoInfo> videoDetail(@RequestParam String vname){
        return videoService.findByVname(vname);
    }
}
