# API-REST

### Unit Tests
```
mvn test
```

### Functional Tests
```
./functional-test/run-test.sh
```

**Start Application / Service from IDE:**
```
Run > src/main/java/com/example/demo/RestApiApplication.java
```

**Start Application / Service from Docker:** 
```
docker build -t my_service . 
docker-compose -f functional-test/docker-compose.yml up --build -d my_service
```

**Note:** If you don't know how to start App with IntelliJ see [IntelliJ Documentation](https://www.jetbrains.com/help/idea/running-applications.html)