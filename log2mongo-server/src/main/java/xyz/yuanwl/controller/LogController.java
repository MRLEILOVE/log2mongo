package xyz.yuanwl.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yuanwl.domain.Log;
import xyz.yuanwl.service.ProdService;
import xyz.yuanwl.service.TestService;
import xyz.yuanwl.vo.Response;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * @author Yuanwl
 * @date 2018/10/26 20:17
 */
@RestController
@RequestMapping("logs")
@Slf4j
public class LogController {
	@Autowired
	private ProdService prodService;

	@Autowired
	private TestService testService;

	@GetMapping
	public Response getLogs(String env, String levelRange, String keyWord, String time, Integer pageNo, Integer pageSize) {
		log.info("{},{},{},{}", env, levelRange, keyWord, time);
		Page<Log> page = null;

		// 切分日志级别范围
		String[] levels = levelRange.split(",");

		// 获取时间段
		String[] times = time.split(" - ");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date start = df.parse(times[0] + " 00:00:00", new ParsePosition(0));
		Date end = df.parse(times[1] + " 23:59:59", new ParsePosition(0));

		// 按时间倒序，创建分页参数
		List<Order> orders = new ArrayList<Order>();
		orders.add(new Order(Direction.DESC, "date"));
		PageRequest pageRequest = new PageRequest(pageNo - 1, pageSize, new Sort(orders)); // MongoDB的页面从0开始，所以pageNo要减1

		if ("prod".equalsIgnoreCase(env)) page = prodService.findLogsByPage(levels, start, end, pageRequest);
		else page = testService.findLogsByPage(levels, start, end, pageRequest);

		if (CollectionUtils.isNotEmpty(page.getContent())) return Response.success(page);
		else return Response.errNotFound("查无日志");
	}
}
