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
  "duration": 3680953400,
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
  "duration": 4598094000,
  "error_message": "org.openqa.selenium.WebDriverException: unknown error: Element is not clickable at point (1198, 620)\n  (Session info: chrome\u003d71.0.3578.98)\n  (Driver info: chromedriver\u003d2.41.578737 (49da6702b16031c40d63e5618de03a32ff6c197e),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-48K146D\u0027, ip: \u002710.0.75.1\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002711.0.2\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 2.41.578737 (49da6702b16031..., userDataDir: C:\\Users\\jorge\\AppData\\Loca...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:49271}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, unexpectedAlertBehaviour: , unhandledPromptBehavior: , version: 71.0.3578.98, webStorageEnabled: true}\nSession ID: 03620f3bdcbff7f77ab4a6aba1f917b0\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\r\n\tat com.sun.proxy.$Proxy24.click(Unknown Source)\r\n\tat pages.Home.CheckHomePage(Home.java:67)\r\n\tat steps.MainPage.iAmOnTheHomePage(MainPage.java:32)\r\n\tat ✽.Given I am on the home page(boxesdisplay.feature:11)\r\n",
  "status": "failed"
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
  "status": "skipped"
});
formatter.match({
  "location": "MainPage.iShouldSeeSuggestionForMySearch()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 131200,
  "status": "passed"
});
});