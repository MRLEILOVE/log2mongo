package xyz.yuanwl.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xyz.yuanwl.config.LogsRtProperties;
import xyz.yuanwl.service.ProdService;
import xyz.yuanwl.service.TestService;

/**
 * <p>日志定时清理任务
 *
 * @author Yuanwl
 * @date 2018/10/21 17:14
 */
@Component
public class LogsCleanupTask {

	@Autowired
	private LogsRtProperties logsRtProperties;

	@Autowired
	private TestService testService;

	@Autowired
	private ProdService prodService;

	/**
	 * 定时执行清理
	 * @author Yuanwl
	 * @date 2018-10-21 18:02:04
	 * @version v1.0.0
	 */
	@Scheduled(cron = "0 0 2 * * ?") // 每天凌晨2点执行
//	@Scheduled(cron = "*/5 * * * * ?") // 每5秒钟执行一次
	public void clean(){
		System.err.println("cleaning...");
		// 清理测试环境日志
		testService.deleteLogsBefore(logsRtProperties.getTest());
		// 清理生产环境日志
		prodService.deleteLogsBefore(logsRtProperties.getProd());
	}
}
