package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue = "steps",
        dryRun = false,
        monochrome = true,
        tags ="@error1",
        plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json","rerun:target/failed.txt"}
        //pretty= it takes care of printing the steps in console
)


public class Smoke {

}
