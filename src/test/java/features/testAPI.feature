Feature:
  @GET
  Scenario: Validate status code and validate email

    Given I open URL
    And I validate status code
    Then I validate email


  @POST
  Scenario: Print Value id and jobs

    Given I hit base URI
    And I validate status code create
    Then I print id and jobs