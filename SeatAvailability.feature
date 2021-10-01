Feature: Train seat availability
  This feature deals with checking train seat availability for the given date, place, time range and also
  availability in the specified date range

  Scenario: scenario 1 - Check the train availability for the given data, place and time range
    Given Open the chrome Browser
    And Load the Indian railway URL
    And Select the Journey date as "26-01-2018"
    And Enter the Source station code as "CHENNAI CENTRAL - MAS"
    And Enter the Destination station code as "KSR BENGALURU - SBC"
    And Click on Go button
    And Wait until user manually enters the captcha
    And Identify the trains between "01:01" to "23:59"
    And Click on the "2S" link here SL refers sleeper

  Scenario: scenario 1 - Check the train availability for the multiple date
    Given Select the Journey date as "26-01-2018"
    And Enter the Source station code as "CHENNAI CENTRAL - MAS"
    And Enter the Destination station code as "KSR BENGALURU - SBC"
    And Click on Go button
    And Wait until user manually enters the captcha
    And Identify the trains between "01:01" to "23:59"
    And Click on the "2S" link here SL refers sleeper