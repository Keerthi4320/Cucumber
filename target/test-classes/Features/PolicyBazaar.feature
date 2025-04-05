@policy
Feature: Validate the PolicyBazaar application.
Background:
Given Launch the PolicyBazaar application "https://www.policybazaar.com/"
Then Validate user lands on PB HomePage

#Scenario: To validate the car insurance
#
#When User clicks Car Insurance option
#Then Validate user lands on Car Insurance section page
#When User giving car details
#And User clicks the View Prices for car insurance

Scenario Outline: To validate the insurance types

When User clicks the Insurance options "<Index>"
Then Validate user lands on Bike Insurance section page 
When User giving Bike details
When User clicks the View Prices for Bike insurance 
And User prints the how many total no. of insurance companies present in that web page
And User prints the Insurance company and price

Examples:
|Index  |
|6      |
#|6      |
#|6    |

#Scenario: To validate the E-Bike insurance
#
#When User MouseHover to Insurance Products option
#And User clicks E-Bike Insurance option
#Then Validate user lands on E-Bike Insurance section page
#When User giving E-Bike details
#And User clicks the View Prices for E-Bike insurance
#And User prints the how many total no. of insurance companies present in that web page
#And User prints the Insurance company and price