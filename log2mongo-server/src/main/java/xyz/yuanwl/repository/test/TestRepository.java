package xyz.yuanwl.repository.test;

import org.springframework.data.mongodb.repository.MongoRepository;
import xyz.yuanwl.domain.Log;
import xyz.yuanwl.repository.CommonRepository;

import java.util.Date;

/**
 * 主数据源的Repository，注意不能和其他数据源放在同一个包下面，否则扫描出错
 * @author Yuanwl
 * @date 2018-10-08 15:49:31
 * @version v1.0.0
 */
public interface TestRepository extends CommonRepository {

}