# Officium
## Project Management
This software is designed to create a light weight task management application.
The software is designed as complete microservice architecture.

The according service is the project management service. It provides CRUD methods
to projects, whereas projects contain tasks. 
Please have a look into interfaceProjectmanagement.yaml.

This is the project management microservice of the Officium application.
The microservices accesses a postgreSQL database - offered in AWS.
A project can be determined by its UUID or its name.
A project can be created by its name. Please refer to the
according OpenAPI description available under

`com/annegret/officium/projectmangement/interfaces/interfaceProjectmanagement.yaml`

## Installation
The microservices is supposed to be installed in AWS (with according connection 
string to the database). Anyhow it is delivered as docker container with 

`docker run -p 5001:5001 annegret/projectmanagement`

In AWS, the microservice is running as daemon.

## Further Microservices

The entire Officium application needs more microservices. The following microservices
are available at the moment:
* Task Management https://github.com/Grinseteddy/officiumTaskmanagement
* User Management https://github.com/Grinseteddy/officiumusermanagement
* Login https://github.com/Grinseteddy/officiumlogin
* Comments (not yet available on Github)

As client, one iOS client is available:
 * https://github.com/Grinseteddy/officium2ios