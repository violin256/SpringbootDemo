package video.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import video.cn.pojo.ResponseObject;
import video.cn.pojo.UserInfo;
import video.cn.service.UserService;
import video.cn.service.UserServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //用户登录
    @PostMapping("/userinfo/login")
    @ResponseBody
    public ResponseObject login(@RequestBody UserInfo userInfo,HttpServletRequest request){

        if(userService.searchUser(userInfo.getUname(),userInfo.getUpwd()).isEmpty())
            return new ResponseObject("登录失败","0",null);
        else{
            UserInfo temp=userService.searchUser(userInfo.getUname(),userInfo.getUpwd()).get(0);
            HttpSession session=request.getSession();
            session.setAttribute("userInfo",temp);
        }
        return new ResponseObject("登录成功","200",null);
    }
    //注册用户
    @PostMapping("/registers")
    @ResponseBody
    public ResponseObject register(@RequestBody UserInfo userInfo,HttpServletRequest request){
        System.out.println(userInfo.toString());
        if(userService.findByEmails(userInfo.getEmails()).size()>0)
            return new ResponseObject("注册失败,该邮箱已被注册","0",null);
        else{
            userService.save(userInfo);
            UserInfo temp=userService.searchUser(userInfo.getUname(),userInfo.getUpwd()).get(0);
            HttpSession session=request.getSession();
            session.setAttribute("userInfo",temp);
        }
        return new ResponseObject("注册成功","200",null);
    }
    //获取用户信息
    @PostMapping("/getUserInfo")
    @ResponseBody
    public UserInfo getUserInfo(HttpServletRequest request){
        System.out.println("获取用户信息");
        HttpSession session=request.getSession();
        if(session.getAttribute("userInfo")!=null)
             return (UserInfo) session.getAttribute("userInfo");
        return null;
    }
    //退出登录
    @GetMapping("/userinfo")
    @ResponseBody
    public boolean exit(HttpServletRequest request){
        //注销session
        //false代表：不创建session对象，只是从request中获取。
        HttpSession session = request.getSession(false);
        if(session==null){
            return false;
        }
        else {
            session.removeAttribute("userInfo");
            return true;
        }


    }
    //修改用户信息
    @PostMapping("/setInfo")
    @ResponseBody
    public ResponseObject setInfo(@RequestBody UserInfo userInfo,HttpServletRequest request){
        System.out.println(userInfo.toString());
        HttpSession session=request.getSession();
        UserInfo temp= (UserInfo) session.getAttribute("userInfo");
        if(userInfo.getUname()!=null)
            temp.setUname(userInfo.getUname());
        else if(userInfo.getLabel()!=null)
            temp.setLabel(userInfo.getLabel());
        else
            return new ResponseObject("修改失败","200",null);
        userService.save(userInfo);

        return new ResponseObject("修改成功","200",null);
    }
}
