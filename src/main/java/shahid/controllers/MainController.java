package shahid.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import graphql.ExecutionResult;
import graphql.GraphQL;
import shahid.graphql_utilities.GraphQlUtility;

@RestController
public class MainController {

	private GraphQL graphQL;
	private GraphQlUtility graphQLUtility;
	
	public MainController(GraphQlUtility graphQlUtility) throws IOException {
		this.graphQLUtility = graphQlUtility;
		
		graphQL = graphQlUtility.createGraphQLObject();
	}
	
	@PostMapping(value = "/query")
	public ResponseEntity query(@RequestBody String query) {
		ExecutionResult result = graphQL.execute(query);
		
		
		System.out.println("errors :"+result.getErrors());
		
		return ResponseEntity.ok(result.getData());
	}
}
