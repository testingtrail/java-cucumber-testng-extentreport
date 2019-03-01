$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("boxesdisplay.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#**************************************************************************"
    },
    {
      "line": 2,
      "value": "#Author: Jorge Quiros"
    },
    {
      "line": 3,
      "value": "#Last updated: 01/19/20"
    },
    {
      "line": 4,
      "value": "#Description: Feature file for boxes display user story"
    },
    {
      "line": 5,
      "value": "#**************************************************************************"
    }
  ],
  "line": 7,
  "name": "Smartbox Boxes Display",
  "description": "As a customer I want to view a list of products so I can select some to purchase",
  "id": "smartbox-boxes-display",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3694348700,
  "status": "passed"
});
formatter.background({
  "line": 10,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 11,
  "name": "I am on the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "MainPage.iAmOnTheHomePage()"
});
formatter.result({
  "duration": 5421898800,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "As a Customer I search in the main field",
  "description": "",
  "id": "smartbox-boxes-display;as-a-customer-i-search-in-the-main-field",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "I look for specific product \"bistrots\" in search box",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I should see suggestion for my search",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "bistrots",
      "offset": 29
    }
  ],
  "location": "MainPage.iLookForSpecificProductInSearchBox(String)"
});
formatter.result({
  "duration": 88244600,
  "status": "passed"
});
formatter.match({
  "location": "MainPage.iShouldSeeSuggestionForMySearch()"
});
formatter.result({
  "duration": 242287500,
  "status": "passed"
});
formatter.after({
  "duration": 57200,
  "status": "passed"
});
formatter.before({
  "duration": 102000,
  "status": "passed"
});
formatter.background({
  "line": 10,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 11,
  "name": "I am on the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "MainPage.iAmOnTheHomePage()"
});
formatter.result({
  "duration": 6811582400,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "As a Customer I can search in the filter box of sub category page",
  "description": "",
  "id": "smartbox-boxes-display;as-a-customer-i-can-search-in-the-filter-box-of-sub-category-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "I look for an specific product in the menu",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "Subcategory page product page appears",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "I should see the filter options",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "I search on the box filter for Title \"3 jours de\"",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "Click on any Box",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "A link for review section should appear",
  "keyword": "Then "
});
formatter.match({
  "location": "MainPage.iLookForAnSpecificProductInTheMenu()"
});
formatter.result({
  "duration": 1509942700,
  "status": "passed"
});
formatter.match({
  "location": "SubCategoryPage.subcategoryPageProductPageAppears()"
});
formatter.result({
  "duration": 52211900,
  "status": "passed"
});
formatter.match({
  "location": "SubCategoryPage.iShouldSeeTheFilterOptions()"
});
formatter.result({
  "duration": 53225100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3 jours de",
      "offset": 38
    }
  ],
  "location": "SubCategoryPage.iSearchOnTheBoxFilterForTitle(String)"
});
formatter.result({
  "duration": 345929100,
  "status": "passed"
});
formatter.match({
  "location": "SubCategoryPage.clickOnAnyBoxProduct()"
});
formatter.result({
  "duration": 3124367700,
  "status": "passed"
});
formatter.match({
  "location": "ProductPage.aLinkForReviewSectionShouldAppear()"
});
formatter.result({
  "duration": 28619500,
  "status": "passed"
});
formatter.after({
  "duration": 35000,
  "status": "passed"
});
});