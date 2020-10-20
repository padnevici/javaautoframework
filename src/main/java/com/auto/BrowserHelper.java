package com.auto;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrowserHelper {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Value("${browser.implicit.timeout}")
  private int implicitTimeout;


  @Value("${browser.screen.width}")
  private int width;


  @Value("${browser.screen.height}")
  private int height;


  @Value("${browser.mode.headless}")
  private boolean headless;

  @Bean(name = "defaultBrowser")
  public WebDriver getDriver() {
    logger.info("---INIT CHROME---");
    // Optional. If not specified, WebDriver searches the PATH for chromedriver.
    System.setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.manage().window().setSize(new Dimension(width, height));
    driver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
    return driver;
  }
}
