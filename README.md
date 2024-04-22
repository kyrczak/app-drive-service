# App Drive Service

## Description
College assignment introducing microservice web infrastructure. The app allows for creation of **drives** and saving **applications** in them.
User can interact with application with a web interface provided by Angular framework.

Every creation of a new **app** or new **disk** is stored on a local database and is loaded on application start-up.
## Tech stack
- Spring
- Sprin Boot
- Angular
- Docker
- PostgresSQL

## Setup
Requirements:
- JDK
- Node.JS
- Docker
- Angular `npm install -g @angular/cli@16.0.1`

Provided, that you installed all required components and clonned the repository
1. Build the project in the main directory using
```
build.ps1
```
2. Launch the docker containers using
```
docker-compose up
```
3. Access the gui interface through this address in your web browser
```
localhost:8087
```
