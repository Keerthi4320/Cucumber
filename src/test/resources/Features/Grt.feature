@grt
Feature: Validate the Male section in GRT application
Scenario: To validate that all the items are displaying in that web page

Given Launch the GRT application "https://www.grtjewels.com/"
Then Validate user lands on HomePage
When mouse hover to All Jewellery option
And User clicks Male option
Then User validates the menu options
When User prints the how many total no. of items should display in that page
Then User validates that total items are displaying in that page
When User prints the Product name and price
