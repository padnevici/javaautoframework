package com.auto;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue = {
    "com.auto"}, plugin = {"pretty", "json:target/report.json",
    "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"})
public class RunCuckeTest {

}
