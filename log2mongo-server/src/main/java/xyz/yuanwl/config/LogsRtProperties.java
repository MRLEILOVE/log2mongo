package xyz.yuanwl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>日志保留时间属性
 *
 * @author Yuanwl
 * @date 2018/10/21 17:19
 */
@Data
@ConfigurationProperties(prefix = "log2mongo.rt")
@Component
public class LogsRtProperties {
	private Integer test;
	private Integer prod;
}
