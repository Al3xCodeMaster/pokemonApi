# Pokemon Api
This API consuming the **RESTful** [PokeApi V2](https://pokeapi.co/docs/v2). The main goal is to provide an easy way to get information such as a particular Pokemon or a list of pokemons.


# About this current build

|                |Packages                         |Version                         |
|----------------|-------------------------------|-----------------------------|
|Java|JDK            |11            |
|  Spring boot   | spring framework            | 2.6.2          |
|Maven          |spring boot maven plugin| 4.0.0|


## Deploy process in Heroku cloud

This app could be consumed via Heroku app in the following [Pokemon Api](https://pokemon-api-modyo.herokuapp.com/api/pokemon).

- The firsts step to deploy a Springboot app using Maven compiler is add the following line to `system.properties`  (in the case of no already created, create a new file):
>java.runtime.version=11
- The next step is create a new heroku app in the dashboard page or CLI commands using **Java Buildpack**.
- Finally, add the repo to git remote origin and push, Heroku will handle the rest of the work for you ;)

## Usage
Documentation can be found in [Api Docs](https://pokemon-api-modyo.herokuapp.com/swagger-ui.html) 