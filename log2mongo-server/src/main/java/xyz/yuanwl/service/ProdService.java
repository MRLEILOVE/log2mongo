package xyz.yuanwl.service;

import org.springframework.stereotype.Service;
import xyz.yuanwl.repository.CommonRepository;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author Yuanwl
 * @date 2018/10/26 16:39
 */
@Service
public class ProdService extends CommonService{
	@Resource(name = "prodRepository") // 获取 prodRepository 对象给方法参数 repository
	@Override
	protected void setRepository(CommonRepository repository){
		super.setRepository(repository);
	}
}
