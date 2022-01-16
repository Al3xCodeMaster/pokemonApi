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

## Api Testing with Postman

![List of Pokemons without limit and offset](https://user-images.githubusercontent.com/42918519/149679580-6b365581-baa3-4b99-b044-10503f0e7d8d.png)
![List of Pokemons with wrong path](https://user-images.githubusercontent.com/42918519/149679586-9af8eb5c-edcb-4dc0-b89b-359ffb0a9699.png)
![List of Pokemons with limit and offset](https://user-images.githubusercontent.com/42918519/149679588-f4435841-2a75-4334-bf5a-80b4661b79fd.png)
![Detailed info about Pokemon](https://user-images.githubusercontent.com/42918519/149679591-2a38eb43-fbe5-40bc-b090-8801a5c1d236.png)
![Wrong id](https://user-images.githubusercontent.com/42918519/149679594-d089ddc6-5d29-40ab-be2e-0e9331431c63.png)
![Caching](https://user-images.githubusercontent.com/42918519/149679689-25d45ecd-2271-4de1-99a3-2c190880d17b.png)

