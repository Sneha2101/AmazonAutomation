 Feature: Automate Amazon process
 
@Web
Scenario: To add phone in cart
	
	Given Amazon is open on "Web Browser" 
	And The user sets his US delivery zip code to "90201"
	When User searches for "Apple iPhone 11 pro max"
	And user then looks for variants locked to the carrier "Simple Mobile"
	Then verifies whether following options are available as options in the search results page 1
	|White|
	|Midnight Green|
	And Select option "Midnight Green" if present
	#Then The user sets his US delivery zip code to "90201"
	Then user adds the product to the cart
	
	@MobileWeb
Scenario: To add phone in cart
	
	Given Amazon is open on "Mobile browser"
	#Then The user sets his US delivery zip code to "90201"
	When User searches for "Apple iPhone 11 pro max"
	And user then looks for variants locked to the carrier "Simple Mobile"
	Then verifies whether following options are available as options in the search results page 1
	|White|
	|Midnight Green|
	And Select option "Midnight Green" if present
	
	Then user adds the product to the cart

	
	