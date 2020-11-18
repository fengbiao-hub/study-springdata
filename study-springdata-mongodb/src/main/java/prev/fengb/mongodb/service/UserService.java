package prev.fengb.mongodb.service;

import java.util.List;

import prev.fengb.mongodb.model.Page;
import prev.fengb.mongodb.model.User;

public interface UserService {

	List<User> findAll(Page page);

	User findById(String id);

	List<User> findByName(String name);

	User add(User user);

	User deleteById(String id);
}
