package xyz.yuanwl.service;

import org.springframework.stereotype.Service;
import xyz.yuanwl.repository.CommonRepository;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * <p>
 *
 * @author Yuanwl
 * @date 2018/10/26 16:39
 */
@Service
public class TestService extends CommonService {
	@Resource(name = "testRepository") // 获取 testRepository 对象给方法参数 repository
	@Override
	protected void setRepository(CommonRepository repository){
		super.setRepository(repository);
	}
}
