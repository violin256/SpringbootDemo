package video.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import video.cn.pojo.*;
import video.cn.service.FeedbackService;
import video.cn.service.UserService;
import video.cn.service.VideoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class SysController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private UserService userService;

    //查询历史记录
    @RequestMapping("/history")
    @ResponseBody
    public List<Map<String, Object>> VideoInfo(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                               @RequestParam(value = "size", defaultValue = "8") Integer size,
                                               HttpServletRequest request) {
        System.out.println("查询历史记录");
        HttpSession session=request.getSession();
        if(session.getAttribute("userInfo")!=null){
            UserInfo u= (UserInfo) session.getAttribute("userInfo");
            return videoService.findByUname(u.getUname());
        }

        return null;


    }
    //查询下载记录
    @RequestMapping("/downloadInfo")
    @ResponseBody
    public List<Map<String, Object>> downloadInfo(HttpServletRequest request) {
        System.out.println("查询下载记录");
        HttpSession session=request.getSession();
        if(session.getAttribute("userInfo")!=null){
            UserInfo u= (UserInfo) session.getAttribute("userInfo");
            return videoService.findDownloadByUname(u.getUname());
        }

        return null;


    }
    //查询收藏记录
    @RequestMapping("/favorInfo")
    @ResponseBody
    public List<Map<String, Object>> favorInfo(HttpServletRequest request) {
        System.out.println("查询收藏记录");
        HttpSession session=request.getSession();
        if(session.getAttribute("userInfo")!=null){
            UserInfo u= (UserInfo) session.getAttribute("userInfo");
            return videoService.findFavorByUname(u.getUname());
        }

        return null;


    }
    @PostMapping("/feedback")
    @ResponseBody
    public ResponseObject register(@RequestBody Feedback feedback, HttpServletRequest request){
        feedbackService.addFeedbackService(feedback);
        return new ResponseObject("注册成功","200",null);
    }
    //增加收藏
    @PostMapping("/addFavor")
    @ResponseBody
    public ResponseObject addFavor(@RequestBody List<VideoInfo> v, HttpServletRequest request){
        System.out.println("增加收藏"+v.toString());
        HttpSession session=request.getSession();
        UserInfo temp= (UserInfo) session.getAttribute("userInfo");
        if(session.getAttribute("userInfo")!=null){
            //获取系统时间
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String time=df.format(new Date());
            Favorites favorites=new Favorites();
            favorites.setDates(time);
            favorites.setDirectors(v.get(0).getDirectors());
            favorites.setFname(v.get(0).getVname());
            favorites.setUname(temp.getUname());
            userService.save(favorites);
            return new ResponseObject("收藏成功","200",null);
        }
        return new ResponseObject("收藏失败！请先登录","200",null);
    }
}