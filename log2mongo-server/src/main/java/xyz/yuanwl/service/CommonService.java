package xyz.yuanwl.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.yuanwl.domain.Log;
import xyz.yuanwl.repository.CommonRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>通用Service
 *
 * @author Yuanwl
 * @date 2018/10/26 15:50
 */
public class CommonService {

	private CommonRepository repository;

	/**
	 * 供子类初始化 repository
	 * @param repository CommonRepository 的子类对象
	 * @author Yuanwl
	 * @date 2018-10-26 17:26:29
	 * @version v1.0.0
	 */
	protected void setRepository(CommonRepository repository){
		this.repository = repository;
	}

	public List<Log> getLogs(){
		return repository.findAll();
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

	public Page<Log> findLogsByPage(String[] levels, Date start, Date end, Pageable pageable){
		return repository.findByLevelInAndDateBetween(levels, start, end, pageable);
	}
}
