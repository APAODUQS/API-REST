Feature: My Service Functional Test

  Background: Setup my service
    Given the service: http://localhost:8080/my-api-rest

  Scenario Outline: Get Petition
    Given the username: <name>
    When the user searches his name
    Then the response is 200
    And the content response is: Hello, <name>!
    Examples:
      | name  |
      | Maria |
      | Juan  |

  Scenario Outline: Post Petition
    Given the user id: <id>
    And the username: <name>
    And the user age: <age>
    And the user is employed: <employed>
    When the user ingress his information
    Then the response is 200
    And the content response has the username: <name>
    And the content response has the age: <age>
    And the content response has the employed: <employed>
    Examples:
      | id | name  | age | employed |
      | 1  | Maria | 15  | false    |
      | 2  | Juan  | 23  | true     |
      | 3  | Pedro | 37  | true     |