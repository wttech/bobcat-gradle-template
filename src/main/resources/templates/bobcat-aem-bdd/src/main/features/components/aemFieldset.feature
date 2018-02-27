@fieldset
Feature: aemFieldset

  Background:
	Given I am logged in

  Scenario: Type to fieldset
	Given I have opened Feedback page
	And I edit start from component
	And my component configuration data is:
	  | tab      | type                | label                             | value           |
	  | Advanced | fieldset#text field | Action Configuration#Content Path | /tmp/formtest/* |
	When I set the rest of the properties using my component configuration data
	Then component is configured according to configuration data
