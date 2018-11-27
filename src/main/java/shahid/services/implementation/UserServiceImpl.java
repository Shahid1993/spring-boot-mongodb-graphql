package shahid.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import shahid.models.User;
import shahid.repositories.UserRepository;
import shahid.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAllUsers() {
		return (ArrayList<User>) userRepository.findAll();
	}

	@Override
	public User findOneById(ObjectId id) {
		return userRepository.findOne(id);
	}

	@Override
	public List<User> findByIdIn(List<String> ids) {
		return userRepository.findByIdIn(ids);
	}

}
