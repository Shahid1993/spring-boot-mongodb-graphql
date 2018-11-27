package shahid.models;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Document(collection = "users")
public class User {

	private ObjectId id;
	
	private String name;
	private Integer age;
	private Date createdAt;
	private String nationality;
	private List<String> friendsIds;
	private List<String> articlesIds;
}
