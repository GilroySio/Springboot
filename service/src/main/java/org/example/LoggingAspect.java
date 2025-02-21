package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* org.example.impl..*(..))")
    public void roleServiceMethods() {
    }

    @Before("roleServiceMethods()")
    public void logBeforeMethod(JoinPoint joinPoint) {
        logger.info("Entering method: " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "roleServiceMethods()", returning = "result")
    public void logAfterMethod(JoinPoint joinPoint, Object result) {
        logger.info("Exiting method: " + joinPoint.getSignature() + " Return value: " + result);
    }

    @AfterThrowing(pointcut = "roleServiceMethods()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        logger.severe("Exiting method: " + joinPoint.getSignature() + " Exception occurred: " + exception.getMessage());
    }

}
