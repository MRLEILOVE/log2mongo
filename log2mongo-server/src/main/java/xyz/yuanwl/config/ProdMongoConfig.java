package xyz.yuanwl.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 生产环境数据源配置
 * @author Yuanwl
 * @date 2018-10-08 15:39:17
 * @version v1.0.0
 */
@SpringBootConfiguration
@EnableMongoRepositories(basePackages = "xyz.yuanwl.repository.prod",
        mongoTemplateRef = ProdMongoConfig.MONGO_TEMPLATE)
public class ProdMongoConfig {
    protected static final String MONGO_TEMPLATE = "prodMongoTemplate";
}