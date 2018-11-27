# spring-boot-mongodb-graphql
Sample Project for GraphQL with Spring Boot and MongoDB

* When running for the first time, `@PostConstruct` annotation on `generateData()` method in shahid\dataLoader\MyDataLoader.java should be uncommented to load data in the mongo database, if you have not created data manually beforehand.   

* Request Json Templates :

```
{
	users{
		name
		age
		createdAt
		friends{
			name
			age
		}
		articles{
			title
			minutesRead
		}
	}
}
```

```
{
	user(id:"5bfcf0fca58fc04d65ff6dab"){
		name
		age
		createdAt
		friends{
			name
			age
		}
		articles{
			title
			minutesRead
		}
	}
}
```

```
{
	users{
		...test
		friends{
			...test
		}
		articles{
			title
			minutesRead
		}
	}
}
fragment test on User{
                name
		age
		createdAt
}
```
