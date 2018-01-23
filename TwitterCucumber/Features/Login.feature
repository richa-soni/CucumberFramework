@Gaurav
@Test_id213
Feature:login into twitter
Description:user chaeck the login functionality

Scenario:check the login functionality
When user loads fixture file "C:\Users\Richa\eclipse-workspace\TwitterCucumber\Fixture\Book2.xlsx"
Given user opens the "#Browser" browser
When user enters the URL "#url"
And user enters the "#UserName" in the textbox "#UserName_ID"
And user enters the "#Password" in the textbox "#Password_ID"
And user click on the button "Log in"


