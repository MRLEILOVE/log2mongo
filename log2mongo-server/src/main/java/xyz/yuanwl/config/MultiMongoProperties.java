package xyz.yuanwl.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 多数据源的属性类，每个数据源的属性分别注入到对应名字的MongoProperties对象中
 * @author Yuanwl
 * @date 2018-10-08 15:36:33
 * @version v1.0.0
 */
@Data
@Component // 不要漏了这个，只用下面的注解是不会创建bean的
@ConfigurationProperties(prefix = "log2mongo.db")
public class MultiMongoProperties {
    private MongoProperties test = new MongoProperties();
    private MongoProperties prod = new MongoProperties();
}