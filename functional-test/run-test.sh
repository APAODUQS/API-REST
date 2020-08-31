#!/bin/bash

cp -f src/main/java/com/apaoduqs/example/DTO/* functional-test/src/test/java/com/apaoduqs/example/DTO/
docker-compose -f functional-test/docker-compose.yml down --rmi local
docker build -t my_service .
docker-compose -f functional-test/docker-compose.yml up --build -d my_service

echo "Waiting 5 seconds, connecting My Service...";
sleep 5;

mvn -f functional-test test

testReturn=$?
docker-compose -f functional-test/docker-compose.yml down --rmi local
exit ${testReturn}
