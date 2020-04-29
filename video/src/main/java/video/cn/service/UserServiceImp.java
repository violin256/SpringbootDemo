package video.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import video.cn.dao.FavoritesRepository;
import video.cn.dao.UserRepository;
import video.cn.pojo.Favorites;
import video.cn.pojo.UserInfo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository dao;
    @Autowired
    private FavoritesRepository favoritesRepository;



    @Override
    public List<UserInfo> searchUser(String uname, String pwd) {
        return dao.findAll(new Specification<UserInfo>() {
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                Predicate condition1 = criteriaBuilder.equal(root.get("uname"),uname);
                Predicate condition2 = criteriaBuilder.equal(root.get("upwd"),pwd);
                query.where(condition1,condition2);
                return null;
            }
        });

    }

    @Override
    public List<UserInfo> findByEmails(String emails) {
        return dao.findByEmails(emails);
    }

    @Override
    public void save(UserInfo userInfo) {
        dao.save(userInfo);
    }

    @Override
    public void save(Favorites favorites) {
        favoritesRepository.save(favorites);
    }
}
