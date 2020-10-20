package com.auto;

import com.auto.page.objects.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class StepHooks {

  Logger logger = LoggerFactory.getLogger(StepHooks.class);

  @Autowired
  BrowserHelper browserHelper;

  @Autowired
  ScenarioContext scenarioContext;

  @Autowired
  HomePage homePage;

  @Value("${application.url}")
  private String applicationUrl;

  @Before
  public void init() {
    logger.info("---INIT---");

    scenarioContext.getPages().put("home", homePage);
    browserHelper.getDriver().navigate().to(applicationUrl);
  }

  @After
  public void tearDown() {
    logger.info("---DONE---");
  }

}
