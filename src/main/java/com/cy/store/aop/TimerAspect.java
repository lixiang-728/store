package com.cy.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimerAspect {
    @Around("execution(* com.cy.store.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {  // ProceedingJoinPoint接口表示连接点
        // 先记录当前时间
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();   // 调用目标方法：login
        // 后记录当前时间
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start)+"ms");
       return result;
    }
}
