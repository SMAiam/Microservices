package com.sma.user.service;

import com.sma.user.VO.Department;
import com.sma.user.VO.ResponseTemplateVO;
import com.sma.user.entity.User;
import com.sma.user.repository.UserRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }
//    public  ResponseTemplateVO serviceFallback(Exception e){
//        log.info("servicefallbackmethod");
//        ResponseTemplateVO vo=new ResponseTemplateVO();
//        vo.setMessage("THIS IS A FALL BACK PAGE FOR USER-SERVICE");
//        return vo;
//    }
//    @CircuitBreaker(name="user-service",fallbackMethod="serviceFallback")

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService");
        ResponseTemplateVO vo=new ResponseTemplateVO();
        User user=userRepository.findByUserId(userId);
        Department department=
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId()
                        ,Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
