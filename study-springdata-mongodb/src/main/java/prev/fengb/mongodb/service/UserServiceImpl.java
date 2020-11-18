package prev.fengb.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import cn.hutool.core.util.IdUtil;
import prev.fengb.mongodb.model.Page;
import prev.fengb.mongodb.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<User> findAll(Page page) {
		Query query = new Query(new Criteria()).with(page);
		return mongoTemplate.find(query, User.class);
//		return mongoTemplate.findAll(User.class);
	}

	@Override
	public User findById(String id) {
		return mongoTemplate.findById(id, User.class);
	}

	@Override
	public List<User> findByName(String name) {
		Query query = new Query(Criteria.where("name").is(name));
		return mongoTemplate.find(query, User.class);
	}

	@Override
	public User add(User user) {
		String uuid = IdUtil.fastSimpleUUID();
		user.setId(uuid);
		return mongoTemplate.save(user);
	}

	@Override
	public User deleteById(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		User remove = mongoTemplate.findAndRemove(query, User.class);
		return remove;
	}

}
