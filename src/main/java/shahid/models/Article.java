package shahid.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Document(collection = "articles")
public class Article {

	private ObjectId id;
	
	private String title;
	private Integer minutesRead;
	private String authorId;
}
