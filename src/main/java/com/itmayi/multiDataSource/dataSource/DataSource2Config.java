package com.itmayi.multiDataSource.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 读取数据源
 */
@Configuration //类似xml配置注册到springBoot容器中
@MapperScan(basePackages="com.itmayi.multiDataSource.test2",
            sqlSessionFactoryRef = "test2SqlSessionFactory")
public class DataSource2Config {

    /**
     * 配置test2数据库
     * 去properties配置文件中读取
     * spring.datasource.test2前缀的相关配置
     * @return
     */
    @Bean(name = "test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    //@Primary
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }


    /**
     * test2的sql会话工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "test2SqlSessionFactory")
    //@Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //加载mapper文件时放开
        //bean.setMapperLocations();
        //new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mapper/test2/*.xml");
        return bean.getObject();
    }


    //事务配置
    @Bean(name="test2TransactionManager")
    //@Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    //配置SQLSessionTemplate
    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory
    ){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
