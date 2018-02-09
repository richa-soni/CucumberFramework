@Gari
@Test_id213
Feature:login into twitter
Description:user chaeck the login functionality

Scenario:check the login functionality
Given user opens the "#Browser" browser
When user loads fixture file "path"
When user enters the URL "#url"
And user click on the link "login"
And user enters the "sonirich01@gmail.com" in the textbox "Username"
And user enters the "password" in the textbox "password"
And user click on the button "Login"

