# demo-graphql-nosql-spring

## Develop Applications Fast and Effortlessly with Oracle NoSQL Database
Work in Progress 👷

## Connect instructions
Work in Progress 👷

In this version, this application connects to Oracle NoSQL Database - non-secure configuration.

You can modify the parameter in the file [application.properties](demo-graphql-nosql-spring/src/main/resources/application.properties)

or

Set the following env variables
````
export NOSQL_ENDPOINT=http://httproxy-nosql:8080 
````

## Deployment and Execution instructions
Work in Progress 👷

Spring Initializr uses maven wrapper so type this:

````
./mvnw clean spring-boot:run
````

Alternatively using your installed maven version type this:

````
mvn clean spring-boot:run
````

or if you want to DEBUG
````
mvn clean compile
mvn exec:java -Dexec.mainClass="graphql.GraphqlApplication" -Dlogging.level.com.oracle.nosql.spring.data=DEBUG
````

## Build instructions
Work in Progress 👷

````
mvn clean package spring-boot:repackage
java -Dlogging.level.com.oracle.nosql.spring.data=DEBUG -cp target/demo-0.0.1-SNAPSHOT.jar \
org.springframework.boot.loader.JarLauncher
````

## Query using curl or your favorite tool

````
curl --location --request POST 'http://193.122.141.228:8080/graphql' \
--header 'Content-Type: application/json' \
--data '{"query":"query { findAllTutorials { id title description  }}"}' | jq

curl --location --request POST 'http://193.122.141.228:8080/graphql' \
--header 'Content-Type: application/json' \
--data '{"query":"query { findAllTutorials { id title description keywords author {name} }}"}' | jq

curl --location --request POST 'http://193.122.141.228:8080/graphql' \
--header 'Content-Type: application/json' \
--data '{"query":"query ($key: String!) { findByKeywords (keyword:$key) { description keywords author {name}   }}","variables":{"key":"spring"}}'  | jq

````

````
query { findAllTutorials { id title description   }}

query ($regexp: String!) { findByDescriptionRegex (regexp:$regexp) { description author {name}   }}

{"regexp":"This.*"}

query ($regexp: String!) { findByAuthorNameRegex (regexp:$regexp) { description author {name}   }}
{"regexp":"Dario.*"}

query ($key: String!) { findByKeywords (keyword:$key) { description keywords author {name}   }}
{"key":"spring"}

mutation {
  createTutorial(title:"test created",description:"dario", keywords:["nosql"], author :{name:"Dario VEGA"}) {
    id
  }
}
````


Note: the current version is deleting all records in the NoSQL table and loading automatically 2 records for test.




