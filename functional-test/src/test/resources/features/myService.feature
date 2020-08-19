Feature: My Service Functional Test

  Background: Setup my service
    Given the service: http://localhost:8080/my-api-rest

  Scenario: Get Petition
    Given the username is: Maria
    When the user does a GET petition
    Then the response is 200