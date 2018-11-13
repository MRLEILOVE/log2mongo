package xyz.yuanwl.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * 多数据源配置类，主要定义每个数据源的 MongoTemplate 和 Factory
 * @author Yuanwl
 * @date 2018-10-08 15:33:34
 * @version v1.0.0
 */
@Configuration
public class MultiMongoConfig {

    @Autowired
    private MultiMongoProperties mongoProperties;

    @Primary
    @Bean(name = TestMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate testMongoTemplate() throws Exception {
        return new MongoTemplate(testFactory(mongoProperties.getTest()));
    }

    public MongoDbFactory testFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }


    @Bean(name = ProdMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate prodMongoTemplate() throws Exception {
        return new MongoTemplate(prodFactory(mongoProperties.getProd()));
    }

    public MongoDbFactory prodFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }

}