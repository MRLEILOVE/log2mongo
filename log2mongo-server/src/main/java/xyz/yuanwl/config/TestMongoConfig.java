package xyz.yuanwl.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 测试环境数据源配置
 * @author Yuanwl
 * @date 2018-10-08 15:38:24
 * @version v1.0.0
 */
@SpringBootConfiguration
// 下面这个注解的作用：用basePackages指定的包下面的repository接口，通过mongoTemplateRef指定的MongoTemplate对象去访问该数据源指定的数据库。
// MongoTemplate对象是在MultipleMongoConfig中创建的，在那里面注入了主数据源的配置
@EnableMongoRepositories(basePackages = "xyz.yuanwl.repository.test",
        mongoTemplateRef = TestMongoConfig.MONGO_TEMPLATE)
public class TestMongoConfig {
    protected static final String MONGO_TEMPLATE = "testMongoTemplate";
}