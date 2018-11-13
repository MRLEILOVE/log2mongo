package xyz.yuanwl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		log.info("输出info");
		log.warn("输出warn");
		log.error("输出error");
		try {
			int i = 1 / 0;
		} catch (Exception e) {
			log.error("测试异常", e);
		}
	}

}
