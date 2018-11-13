package xyz.yuanwl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.yuanwl.domain.Log;

import java.util.Date;

/**
 * <p>通用增删改查
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


	Page<Log> findByLevelInAndDateBetween(String[] levels, Date start, Date end, Pageable pageable);
}
