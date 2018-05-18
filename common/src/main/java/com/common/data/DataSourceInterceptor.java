package com.common.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.aspectj.lang.JoinPoint;

/**
 * Created by logan on 2018/5/7.
 */
public class DataSourceInterceptor {

    public void before(JoinPoint joinPoint){
        if (joinPoint.getTarget().getClass().getName().indexOf("Dj")>0){
            MultipleDataSource.setDataSourceKey("qimingDataSource");
        }else {
            MultipleDataSource.setDataSourceKey("mysqlDataSource");
        }

    }

}
