Feature: Search NSW Media Releases

Scenario Outline: Search For Media Releases By Minsiter's Name

Given user is already on search page
When title of search page is Ministerial media releases
Then ministername accordion is expanded
Then user selects "<ministername>" and click search
Then relavant medicacards are displayed with "<texttoverify>"
Then Close the browser

Examples:
	| ministername | texttoverify |
	| Treasurer  |  Treasurer |    
	