Feature: Search NSW Media Releases

Scenario Outline: Reset Minister Filter

Given user is already on search page
When title of search page is Ministerial media releases
Then ministername accordion is expanded
Then user selects "<ministername>" and click search
Then relavant medicacards are displayed with "<texttoverify>"
Then user clicks Reset button and filters are removed
Then Close the browser

Examples:
	| ministername | texttoverify |
	| Treasurer  |  Treasurer |    
	 
	