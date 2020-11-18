package prev.fengb.mongodb;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import prev.fengb.mongodb.model.Page;
import prev.fengb.mongodb.model.User;
import prev.fengb.mongodb.service.UserService;

@SpringBootTest
class StudySpringdataMongodbApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {

	}

	@Test
	void addAUser() {
		User user = new User(null, "zhangcy", 18, "是她啊");
		User add = userService.add(user);
		System.out.println(add);
	}

	@Test
	void addUsers() {
		for (int i = 0; i < 100; i++) {
			User user = new User(null, "user-" + i, new Random().nextInt(100), "第" + i + "个用户");
			userService.add(user);
		}
	}

	@Test
	void findAll() {
		Page page = new Page(1, 10, Sort.by("age"));
		List<User> users = userService.findAll(page);
		System.out.println(users);
	}

	@Test
	void findByName() {
		List<User> users = userService.findByName("fengb");
		System.out.println(users);
	}
	
	@Test
	void delete() {
		User user = userService.deleteById("65c4429e81ec4efd84fc2f4b4b8fb2e4");
		System.out.println(user);
	}

}
