package xyz.yuanwl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 设置默认页，输入域名可以自动跳转到指定的默认网页
 * @author Yuanwl
 * @date 2018-11-13 14:46:28
 * @version v1.0.0
 */
@Configuration
public class DefaultView extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// 访问根路径重定向到登录页
		registry.addViewController("/").setViewName("redirect:/static/login.html");
		// Order设置为HIGHEST_PRECEDENCE，防止与应用中的Controller映射冲突
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}
}