package video.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import video.cn.dao.TTypeRepository;
import video.cn.dao.VideoRepository;
import video.cn.pojo.TtypesInfo;
import video.cn.pojo.VideoInfo;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImp implements VideoService{
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private TTypeRepository tTypeRepository;
    @Override
    public Page<VideoInfo> findAll(int page, int size, String type) {

        Pageable pageable= new PageRequest(page, size, Sort.Direction.ASC, "vno");
        return videoRepository.findAll(new Specification<VideoInfo>() {
            @Override
            public Predicate toPredicate(Root<VideoInfo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate condition1 = criteriaBuilder.equal(root.get("classify"),type);
                query.where(condition1);
                return null;
            }
        },pageable);
    }
    @Override
    public Page<VideoInfo> findAll2(int page, int size, String type) {

        Pageable pageable= new PageRequest(page, size, Sort.Direction.ASC, "vno");

            return videoRepository.findByVno(pageable,type);
    }

    @Override
    public List<VideoInfo> findEndPage(int page, int size, String type) {
        int start=page*8;
        return videoRepository.findByType(type,start,size);
    }

    @Override
    public Page<VideoInfo> findAllByVname(int page, int size, String type) {
        Pageable pageable= new PageRequest(page, size, Sort.Direction.ASC, "vno");
        return videoRepository.findAll(new Specification<VideoInfo>() {
            @Override
            public Predicate toPredicate(Root<VideoInfo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate condition1 = criteriaBuilder.like(root.get("vname"),"%"+type+"%");

                query.where(condition1);
                return null;
            }
        },pageable);
    }

    @Override
    public List<VideoInfo> findByVname(String vname) {
        return videoRepository.findAll(new Specification<VideoInfo>() {
            @Override
            public Predicate toPredicate(Root<VideoInfo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate condition1 = criteriaBuilder.equal(root.get("vname"),vname);
                query.where(condition1);
                return null;
            }
        });
    }

//    @Override
//    public Page<VideoInfo> findByUname(int page, int size, String uname) {
//        Pageable pageable= new PageRequest(page, size, Sort.Direction.ASC, "vno");
//
//        return videoRepository.findByUname(pageable,uname);
//    }
    @Override
    public List<Map<String, Object>> findByUname(String uname){

        return videoRepository.findByUname(uname);
    }
    @Override
    public List<Map<String, Object>> findDownloadByUname(String uname){

        return videoRepository.findDownloadByUname(uname);
    }

    @Override
    public List<Map<String, Object>> findFavorByUname(String uname) {
        return videoRepository.findFavorByUname(uname);
    }
}
