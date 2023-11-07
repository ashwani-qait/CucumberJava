$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/OrangeHRM.feature");
formatter.feature({
  "name": "Feature to test Login Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Verify user able to login with valid cred",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User opens URL \"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.OrangeHRMSteps.user_opens_url(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enters username \"Admin\" and password \"admin123\"",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.OrangeHRMSteps.user_enters_username_and_password(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.OrangeHRMSteps.user_click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify table contents in  Holidays list - Navigate to configure \u0026 Holidays",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@important"
    }
  ]
});
formatter.step({
  "name": "User navigate to configure \u0026 Holidays",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.OrangeHRMSteps.user_navigate_Holiday_Tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify all Holidays label and its date",
  "rows": [
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.OrangeHRMSteps.verify_holidays_contents_And_Date(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify date of given Holiday name \"June Day (Canada)\" and date \"2023-12-25\"",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.OrangeHRMSteps.verify_holidays_(java.lang.String,java.lang.String)"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003c2023-[06-22]\u003e but was:\u003c2023-[12-25]\u003e\n\tat org.junit.Assert.assertEquals(Assert.java:117)\n\tat org.junit.Assert.assertEquals(Assert.java:146)\n\tat StepDefinitions.OrangeHRMSteps.verify_holidays_(OrangeHRMSteps.java:116)\n\tat ✽.verify date of given Holiday name \"June Day (Canada)\" and date \"2023-12-25\"(file:///home/qainfotech/eclipse-workspace/CucumberJava/src/test/resources/Features/OrangeHRM.feature:37)\n",
  "status": "failed"
});
});