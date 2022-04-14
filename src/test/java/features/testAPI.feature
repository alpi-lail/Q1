@all
Feature: REST API
  @GET
  Scenario: as an user can validate status code and validate email

    Given user hit endpoint get
    And user validate status code
    Then user validate email


  @POST
  Scenario: as an user can post endpoint create with status code 200 then Print Value id and jobs

    Given user hit endpoint create
    And user validate status code create
    Then user print id and jobs