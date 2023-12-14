# Employee-backoffice

A Spring boot full stack web application that lets you add, delete, edit and update employees information. Uses Angular for the frontend.

Application is build on three microservices: employee-backoffice-db, employee-backoffice-be, employee-backoffice-fe

## employee-backoffice-db
Service contains sample employees database in Mysql. The database contains about 300,000 employee records with 2.8 million salary entries. 
The export data is 167 MB, which is not huge, but heavy enough to be non-trivial for testing.

* [Documentation](employee-backoffice-db/README.md)

## employee-backoffice-be
Service provide backend implementation of the Spring Employee-backoffice application only provides a REST API.

* [Documentation](employee-backoffice-be/README.md)

## employee-backoffice-fe
Service provide frontend implementation of the Angular Employee-backoffice application consume REST API from employee-backoffice-be service.

* [Documentation](employee-backoffice-fe/README.md)

## How to run
```bash
docker build --tag employee-backoffice-db employee-backoffice-db/.
docker build --tag employee-backoffice-be employee-backoffice-be/.

docker compose up
```

## How to install Docker on Ubuntu
```bash
# Install docker from snap
sudo snap install docker

# Running Docker as normal user
sudo addgroup --system docker
sudo adduser $USER docker
newgrp docker
sudo snap disable docker
sudo snap enable docker
```