package com.common.data;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by logan on 2018/5/7.
 */
@Component
@Aspect
public class MultipleDataSourceAspectAdvice {
    @Around("execution(* com.common.*.*.*.*(..)")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {

        if (jp.getTarget().getClass().getName().startsWith("IDj")) {
            MultipleDataSource.setDataSourceKey("qimingDataSource");
        } else{
            MultipleDataSource.setDataSourceKey("mysqlDataSource");
        }
        return jp.proceed();
    }
}
