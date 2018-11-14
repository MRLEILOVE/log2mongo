package xyz.yuanwl.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.yuanwl.domain.Log;
import xyz.yuanwl.repository.CommonRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>通用Service。测试环境和生产环境只是数据库不一样，但是增删改查都一样的，所以抽象出一个父接口给他们继承即可。
 *
 * @author Yuanwl
 * @date 2018/10/26 15:50
 */
public class CommonService {

	private CommonRepository repository;

	/**
	 * 供子类初始化 repository，不同环境用不同的 repository
	 * @param repository CommonRepository 的子类对象
	 * @author Yuanwl
	 * @date 2018-10-26 17:26:29
	 * @version v1.0.0
	 */
	protected void setRepository(CommonRepository repository){
		this.repository = repository;
	}

	/**
	 * 获取所有日志
	 * @return java.util.List<xyz.yuanwl.domain.Log>
	 * @author Yuanwl
	 * @date 2018-11-14 09:36:24
	 * @version v1.0.0
	 */
	public List<Log> findAllLogs(){
		return repository.findAll();
	}

	/**
	 * 分页查找日志
	 * @param levels 日志等级范围
	 * @param start 开始时间
	 * @param end 截止时间
	 * @param pageable 分页参数
	 * @return org.springframework.data.domain.Page<xyz.yuanwl.domain.Log>
	 * @author Yuanwl
	 * @date 2018-11-14 09:37:20
	 * @version v1.0.0
	 */
	public Page<Log> findLogsByPage(String[] levels, Date start, Date end, Pageable pageable){
		return repository.findByLevelInAndDateBetween(levels, start, end, pageable);
	}

	/**
	 * 删除n天前的日志
	 * @param n 几天前（传正数）
	 * @return 删除了多少条
	 * @author Yuanwl
	 * @date 2018-10-26 16:36:12
	 * @version v1.0.0
	 */
	public int deleteLogsBefore(int n){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -n);
		return repository.deleteByDateLessThan(calendar.getTime());
	}

}
