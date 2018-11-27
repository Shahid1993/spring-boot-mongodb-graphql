package shahid.graphql_utilities;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import shahid.dataFetchers.AllUsersDataFetcher;
import shahid.dataFetchers.ArticlesDataFetcher;
import shahid.dataFetchers.UserDataFetcher;

import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

@Component
public class GraphQlUtility {

	@Value("classpath:schemas.graphqls")
	private Resource schemaResource;
	private GraphQL graphQL;
	
	private AllUsersDataFetcher allUsersDataFetcher;
	private UserDataFetcher userDataFetcher;
	private ArticlesDataFetcher articlesDataFetcher;
	
	@Autowired
	public GraphQlUtility(AllUsersDataFetcher allUsersDataFetcher, UserDataFetcher userDataFetcher,
			ArticlesDataFetcher articlesDataFetcher) throws IOException{
		this.allUsersDataFetcher = allUsersDataFetcher;
		this.userDataFetcher = userDataFetcher;
		this.articlesDataFetcher = articlesDataFetcher;
	}
	
	@PostConstruct
	public GraphQL createGraphQLObject () throws IOException{
		File schemas = schemaResource.getFile();
		
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
		RuntimeWiring wiring = buildRuntimeWiring();
		
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		
		return newGraphQL(schema).build();
	}
	
	public RuntimeWiring buildRuntimeWiring() {
		return newRuntimeWiring()
				.type("Query", typewiring -> typewiring
						.dataFetcher("users", allUsersDataFetcher)
						.dataFetcher("user", userDataFetcher))
				.type("User", typewiring -> typewiring
						.dataFetcher("articles", articlesDataFetcher)
						.dataFetcher("friends", allUsersDataFetcher))
				.build();
	}	
	
}
