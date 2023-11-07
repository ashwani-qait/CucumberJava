Feature: Feature to test Login Functionality

  Background: Verify user able to login with valid cred
    Given User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User enters username "Admin" and password "admin123"
    And User click on login button

  @smoke
  Scenario: Verify search functionality in left side bar
    When User enters text "Admin" in search Textfield
    And verify that only "Admin" is visible in menu
    And User enters text "admin123" in search Textfield
    Then verify no results is shown in menu

	
	@important
  Scenario: Verify table contents in  Holidays list - Navigate to configure & Holidays
    When User navigate to configure & Holidays
    And verify all Holidays label and its date
      | Holiday Name                            | Date       |
      | New Year's Day                          | 2023-01-01 |
      | St. Patrick's Day (Canada)              | 2023-03-16 |
      | St. George's Day(Canada)                | 2023-04-20 |
      | Victoria Day (Canada)                   | 2023-05-18 |
      | National Aboriginal Day (Canada)        | 2023-06-21 |
      | June Day (Canada)                       | 2023-06-22 |
      | The National Holiday of Quebec (Canada) | 2023-06-24 |
      | Canada Day (Canada)                     | 2023-07-01 |
      | Independence Day (US)                   | 2023-07-04 |
      | Nunavut Day (Canada)                    | 2023-07-09 |
      | Orangeman's Day (Canada)                | 2023-07-13 |
      | Remembrance Day (Canada)                | 2023-11-11 |
      | Veterans Day (US)                       | 2023-11-12 |
      | Christmas Day                           | 2023-12-25 |
      | Boxing Day                              | 2023-12-26 |
      | Boxing Day (Canada)                     | 2023-12-28 |
    And verify date of given Holiday name "June Day (Canada)" and date "2023-06-22"
