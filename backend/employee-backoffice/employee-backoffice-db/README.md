# Employee-backoffice-db
Docker image contains sample emloyee database running on MySQL.

## About database
The Employees sample database was developed by Patrick Crews and Giuseppe Maxia and provides a combination of a large base of data (approximately 160MB) spread over six separate tables and consisting of 4 million records in total. The structure is compatible with a wide range of storage engine types. Through an included data file, support for partitioned tables is also provided. 

The database contains about 300,000 employee records with 2.8 million salary entries. The export data is 167 MB, which is not huge, but heavy enough to be non-trivial for testing.

## Database tables
![Database tables](https://github.com/datacharmer/test_db/blob/master/images/employees.png?raw=true)

## Running employee-backoffice-db locally
```bash
git clone https://github.com/GeorgeQuantAnalyst/employee-backoffice
docker build --tag employee-backoffice-db employee-backoffice-db/.
docker composite up
```

## Resources
* [employees-introduction - dev.mysql.com](https://dev.mysql.com/doc/employee/en/employees-introduction.html)
* [employee database - github.com](https://github.com/datacharmer/test_db)
* [install docker - snapcraft.io](https://snapcraft.io/docker)
* [mysql-employees docker image - docker.com](https://hub.docker.com/r/genschsa/mysql-employees)
