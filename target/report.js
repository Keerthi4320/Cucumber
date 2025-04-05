$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri(".\\src\\test\\resources\\Features\\Grt.feature");
formatter.feature({
  "name": "Validate the Male section in GRT application",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@grt"
    }
  ]
});
formatter.scenario({
  "name": "To validate that all the items are displaying in that web page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@grt"
    }
  ]
});
formatter.embedding("image/png", "embedded0.png");
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Launch the GRT application \"https://www.grtjewels.com/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "Grt.launch_the_grt_application(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate user lands on HomePage",
  "keyword": "Then "
});
formatter.match({
  "location": "Grt.validate_user_lands_on_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "mouse hover to All Jewellery option",
  "keyword": "When "
});
formatter.match({
  "location": "Grt.mouse_hover_to_all_jewellery_option()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks Male option",
  "keyword": "And "
});
formatter.match({
  "location": "Grt.user_clicks_male_option()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User validates the menu options",
  "keyword": "Then "
});
formatter.match({
  "location": "Grt.user_validates_the_menu_options()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User prints the how many total no. of items should display in that page",
  "keyword": "When "
});
formatter.match({
  "location": "Grt.user_prints_the_how_many_total_no_of_items_should_display_in_that_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User validates that total items are displaying in that page",
  "keyword": "Then "
});
formatter.match({
  "location": "Grt.user_validates_that_total_items_are_displaying_in_that_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User prints the Product name and price",
  "keyword": "When "
});
formatter.match({
  "location": "Grt.user_prints_the_product_name_and_price()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});