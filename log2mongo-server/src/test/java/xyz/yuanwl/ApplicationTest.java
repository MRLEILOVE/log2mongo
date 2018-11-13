package xyz.yuanwl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.yuanwl.domain.Log;
import xyz.yuanwl.repository.CommonRepository;
import xyz.yuanwl.repository.test.TestRepository;
import xyz.yuanwl.repository.prod.ProdRepository;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	//	@Autowired
	@Resource(name = "testRepository")
	private CommonRepository testRepository;

	//	@Autowired
	@Resource(name = "prodRepository")
	private CommonRepository prodRepository;

	@Test
	public void TestSave() {

		System.out.println("************************************************************");
		System.out.println("测试开始");
		System.out.println("************************************************************");

//		testRepository
//				.save(new Log(null, "第一个库的对象"));
//		prodRepository
//				.save(new Log(null, "第二个库的对象"));

		List<Log> primaries = testRepository.findAll();
		for (Log test : primaries) {
			System.out.println(test);
		}

		List<Log> secondaries = prodRepository.findAll();

		for (Log prod : secondaries) {
			System.out.println(prod);
		}

		System.out.println("************************************************************");
		System.out.println("测试完成");
		System.out.println("************************************************************");
	}

}