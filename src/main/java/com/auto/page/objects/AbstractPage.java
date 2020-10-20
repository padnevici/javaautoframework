package com.auto.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractPage {

  @Value("${browser.implicit.timeout}")
  private int implicitTimeout;

  protected WebDriver _driver;
  protected WebDriverWait _wait;

  public AbstractPage(WebDriver driver) {
    this._driver = driver;
    this._wait = new WebDriverWait(_driver, implicitTimeout);
  }

  protected void waitForLoad(WebElement element) {
    _wait.until(ExpectedConditions.visibilityOf(element));
  }
}
