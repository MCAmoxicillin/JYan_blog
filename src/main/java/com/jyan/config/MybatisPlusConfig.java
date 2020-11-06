package com.jyan.config;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Configuration
@MapperScan("com.jyan.mapper")
@SuppressWarnings("all")
public class MybatisPlusConfig {
    public class MyMetaObjectHandler implements MetaObjectHandler {
        @Override
        public void insertFill(MetaObject metaObject) {


            // setFieldValByName方法中参数分别为实体类的属性名、要填充的值，元数据对象
            this.setFieldValByName("createdTime", new Date(), metaObject);
            this.setFieldValByName("updatedTime", new Date(), metaObject);
        }
        @Override
        public void updateFill(MetaObject metaObject) {
            this.setFieldValByName("updatedTime", new Date(), metaObject);
        }
    }

}
