package xyz.yuanwl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.yuanwl.domain.Log;

import java.util.Date;

/**
 * <p>通用增删改查。测试环境和生产环境只是数据库不一样，但是增删改查都一样的，所以抽象出一个父接口给他们继承即可。
 *
 * @author Yuanwl
 * @date 2018/10/21 18:00
 */
public interface CommonRepository extends MongoRepository<Log, String> {
	/**
	 * 根据时间日期小于date删除日志
	 * @param date 时间日期
	 * @return int
	 * @author Yuanwl
	 * @date 2018-11-10 09:38:07
	 * @version v1.0.0
	 */
	int deleteByDateLessThan(Date date);

	/**
	 * 根据日志等级在某个范围内&时间日期在某个范围内分页查找日志
	 * @param levels 日志等级范围
	 * @param start 开始时间
	 * @param end 截止时间
	 * @param pageable 分页参数
	 * @return org.springframework.data.domain.Page<xyz.yuanwl.domain.Log>
	 * @author Yuanwl
	 * @date 2018-11-14 09:33:30
	 * @version v1.0.0
	 */
	Page<Log> findByLevelInAndDateBetween(String[] levels, Date start, Date end, Pageable pageable);
}
