package shahid.dataFetchers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import shahid.models.User;
import shahid.services.UserService;

@Component
public class AllUsersDataFetcher implements DataFetcher<List<User>> {
	
	private final UserService userService;
	
	public AllUsersDataFetcher(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<User> get(DataFetchingEnvironment env) {
		
		User user = env.getSource();
		
		List<User> friends = new ArrayList<>();
		
		if(user != null) {
			friends = userService.findByIdIn(user.getFriendsIds());
		}else {
			friends = userService.findAllUsers();
		}
		
		return friends;
	}

}
