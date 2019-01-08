$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("test/cbs-apple-acct-gen.feature");
formatter.feature({
  "name": "runner",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Apple account can be created",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@First"
    }
  ]
});
formatter.step({
  "name": "user creates account",
  "keyword": "When "
});
formatter.match({
  "location": "steps.createAppleAcc()"
});
formatter.result({
  "status": "passed"
});
});