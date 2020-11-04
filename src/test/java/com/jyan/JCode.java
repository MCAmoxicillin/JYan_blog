package com.jyan;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class JCode {
    public static void main(String[] args) {
        //代码自动生成器对象
        AutoGenerator jcode = new AutoGenerator();
        //全局配置
        GlobalConfig jconfig = new GlobalConfig();
        String jpath = System.getProperty("user.dir");
        jconfig.setOutputDir(jpath+"/src/main/java");
        jconfig.setAuthor("江延");
        jconfig.setOpen(false);
        jconfig.setFileOverride(false);
        jconfig.setIdType(IdType.ASSIGN_ID);
        jconfig.setDateType(DateType.ONLY_DATE);
        jconfig.setSwagger2(true);
        jcode.setGlobalConfig(jconfig);
        //设置数据源
        DataSourceConfig jdata = new DataSourceConfig();
        jdata.setUrl("jdbc:mysql://localhost:3306/jblog?characterEncoding=UTF-8&useUnicode=true&useSSL=false&tinyInt1isBit=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai");
        jdata.setDriverName("com.mysql.cj.jdbc.Driver");
        jdata.setUsername("root");
        jdata.setPassword("123456");
        jdata.setDbType(DbType.MYSQL);
        jcode.setDataSource(jdata);
        //配置生成包
        PackageConfig jpackage = new PackageConfig();
        jpackage.setParent("com.jyan");
        jpackage.setEntity("entity");
        jpackage.setMapper("mapper");
        jpackage.setService("service");
        jpackage.setServiceImpl("service/impl");
        jpackage.setController("controller");
        jcode.setPackageInfo(jpackage);
        //策略配置
        StrategyConfig jstrategy = new StrategyConfig();
        String[] n={"article","category","comments","user"};
        jstrategy.setInclude(n);
        jstrategy.setNaming(NamingStrategy.underline_to_camel);
        jstrategy.setColumnNaming(NamingStrategy.underline_to_camel);
        jstrategy.setEntityLombokModel(true);
        //自动填充配置
        TableFill jct = new TableFill("created_time", FieldFill.INSERT);
        TableFill jUt = new TableFill("update_time", FieldFill.UPDATE);
        List<TableFill> jt = new ArrayList<>();
        jt.add(jct);
        jt.add(jUt);
        jstrategy.setTableFillList(jt);
        jcode.setStrategy(jstrategy);


        //执行
        jcode.execute();
    }
}
