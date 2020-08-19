#!/bin/bash

docker-compose -f functional-test/docker-compose.yml down --rmi local
docker build -t my_service .
docker-compose -f functional-test/docker-compose.yml up --build -d my_service

echo "Waiting 10 seconds, connecting My Service...";
sleep 10;

mvn clean
mvn package
mvn -f functional-test test

testReturn=$?
docker-compose -f functional-test/docker-compose.yml down --rmi local
exit ${testReturn}
