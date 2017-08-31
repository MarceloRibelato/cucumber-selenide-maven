@all
@azure
Feature: Digital Client Solutions

  Background:
    Given I navigate to "srw-dcs-dev-web.dcs.swissre.com"

  Scenario: Smoke Test
    Then I am navigated to "Solution Catalogue" page
    And there should be at least 1 service provided

  Scenario: Service Details Page
    When I want to see more details for "SwiftRe" service
    Then I am navigated to "SwiftRe" page

  Scenario: Subscribing for a service
    Given I want to see more details for "SwiftRe" service
    When I want to subscribe for the service
    Then I am navigated to "Login" page







