package video.cn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import video.cn.dao.FeedbackRepository;
import video.cn.pojo.Feedback;

@Service
public class FeedbackServiceImp implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Override
    public void addFeedbackService(Feedback feedback) {
        feedbackRepository.save(feedback);
    }
}
