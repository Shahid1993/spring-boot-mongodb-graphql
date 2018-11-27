package shahid.services;

import java.util.List;

import org.bson.types.ObjectId;

import shahid.models.User;

public interface UserService {

	List<User> findAllUsers();
	User findOneById(ObjectId id);
	List<User> findByIdIn(List<String> ids);
}
