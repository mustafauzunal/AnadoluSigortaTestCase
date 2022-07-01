package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/shopping.feature",
        glue = {"org.doganerkoc"},
        plugin = {"pretty", "html:target/HtmlReports.html"}
)
public class Run {

}
