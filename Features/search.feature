Feature: Login Feature
  Verify if user is able to Login in to the site

	@AutoSuggest
  Scenario: Login as a authenticated user
    Given user is  on homepage
    When user search for "engineer"
    Then auto suggest results should contain text "engineer"
    And close the browser
    
  @SearchResult
  Scenario: Login as a authenticated user
    Given user is  on homepage
    When user search for "engineer"
    And user click on seach button
    Then searched results should contain text "engineer"
    And close the browser