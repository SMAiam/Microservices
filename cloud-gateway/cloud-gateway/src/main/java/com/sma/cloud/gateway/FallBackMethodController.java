package com.sma.cloud.gateway;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FallBackMethodController {
    @GetMapping("/userServiceFallBack")
    @CircuitBreaker(name="userService", fallbackMethod = "userServiceFallbackMethod")
    public String userServiceFallBackMethod(){
        log.info("Inside userServiceFallBackMethod");
        return "User Service is taking longer than expected."+
                " Please Try again later";

    }

    @GetMapping("/departmentServiceFallBack")
    @CircuitBreaker(name="departmentService", fallbackMethod = "departmentServiceFallbackMethod")
    public String departmentServiceFallBackMethod(){
        log.info("Inside departmentServiceFallBackMethod");
        return "Department Service is taking longer than expected."+
                " Please Try again later";

    }
}
