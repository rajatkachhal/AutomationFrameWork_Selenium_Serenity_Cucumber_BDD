Feature: POC for serenity

  Scenario Outline: Fetching the agents results as per given criteria and storing the details in CSV file
    Given the user is on Qatar Property Finder home page
    When User search for property "<PropertyType>" to "<LeaseType>" in location "<Location>" with minimum "<MinimumBed>" and maximum "<MaximumBed>"
    Then User should see the search results
    And User should be able sort results by "<FilterOption>"
    And User able to store results in an CSV file
    Examples:
      | PropertyType | LeaseType | Location  | MinimumBed | MaximumBed | FilterOption |
      | Villa        | Buy       | The Pearl | 3 Bedrooms | 7 Bedrooms | Price (high) |


  Scenario Outline: Agents Check
    Given The User is on UAE property Finder home page
    When User searches for agents who can speak languages "<language>"
    When User notes down the total count of Agents and selects "<country>" and verifies with present count

    Examples:
      | language               | country |
      | Hindi, English, Arabic | India   |


  Scenario: Capture Agent Data and store in text file
    Given The User is on UAE property Finder home page
    When The User traverses to agent page and selects the first agent
    When The User captures the information of agent in text file
    Given User Changes the language to Arabic

  Scenario Outline: This is an example of failure to show screenshot on failed steps
    Given the user is on Qatar Property Finder home page
    When User search for property "<PropertyType>" to "<LeaseType>" in location "<Location>" with minimum "<MinimumBed>" and maximum "<MaximumBed>"

    Examples:
      | PropertyType | LeaseType | Location | MinimumBed | MaximumBed |
      | abc          | def       | zzz      | sss        | dddd       |

