## Steps to build and run

### 1) cd to Project root directory and run below command

./mvnw clean install

### Run the below command to start spring app

java -jar target/clock-0.0.1-SNAPSHOT.jar

### Test the API to convert the time

Example : curl -X GET "http://localhost:8080/clock/convert?time=08:59"