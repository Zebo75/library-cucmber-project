package com.zebo.library.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "html:target/cucumber_report.html",
        },
        features = "src/test/resources/features",// copied from go to features package copy/path reference anc choose copy
        // path form content root and paste it inside the features brackets
        glue="com/zebo/library/step_definitions",// the same thin but choose from source root
        dryRun = false,
        tags="@addingUser"
)
public class CukesRunner {
}
