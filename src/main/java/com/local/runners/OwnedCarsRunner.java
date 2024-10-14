package com.local.runners;

import com.atf.base.BaseRunner;
import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/site/cucumber-report",
                "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-report-html/extent-reports/report.html"
        },
        monochrome = true,
        glue = "steps",
        tags = {"@Owned_Cars", "~@Ignore"})
public class OwnedCarsRunner extends BaseRunner {
}
