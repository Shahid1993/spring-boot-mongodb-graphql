package shahid.dataFetchers;

import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import shahid.models.User;
import shahid.services.UserService;

@Component
public class UserDataFetcher implements DataFetcher<User>{
	
	private final UserService userService;
	
	@Autowired
	public UserDataFetcher(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User get(DataFetchingEnvironment env) {
		Map args = env.getArguments();
		
		User user = userService.findOneById(new ObjectId(String.valueOf(args.get("id"))));
		
		return user;
	}

	
}
