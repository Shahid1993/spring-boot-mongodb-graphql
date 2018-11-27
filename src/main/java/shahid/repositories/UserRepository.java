package shahid.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

import shahid.models.User;

public interface UserRepository extends PagingAndSortingRepository<User, ObjectId> {

	List<User> findByIdIn(List<String> ids);
}
