package video.cn.service;

import video.cn.pojo.Favorites;
import video.cn.pojo.UserInfo;

import java.util.List;

public interface UserService {
    //查询用户信息
    public List<UserInfo> searchUser(String uname,String pwd);
    public List<UserInfo> findByEmails(String emails);
    //注册用户/修改用户
    public void save(UserInfo userInfo);
    //增加收藏记录
    public void save(Favorites favorites);

}
