# spring boot jdbc

## Setup mysql using docker
``` bash
docker run -it --name mysql-container \
        -e MYSQL_ROOT_PASSWORD=password \
        -e MYSQL_DATABASE=test_database \
        -p 3306:3306 -d \
         mysql:latest
```