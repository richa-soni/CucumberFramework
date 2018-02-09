@Gaurav
@Test_id213
Feature:login into twitter
Description:user chaeck the login functionality

Scenario:check the login functionality
* user loads fixture file "C:\Users\Richa\git\CucumberFramework\Fixture\Book2.xlsx"
#When user "post" "status" as "happy anniversary to" in twitter
Given user opens the "#Browser" browser
When user enters the URL "#url"
And user verfies the text
|Element|Log in|
|displayed|Yes|
And user enters the "#UserName" in the textbox "#UserName_ID"
And user enters the "#Password" in the textbox "#Password_ID"
And user click on the button "Log in"


