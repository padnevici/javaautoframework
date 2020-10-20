package com.auto.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Question1Chunk extends AbstractPage {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @FindBy(xpath = "//button[@data-testid='decrementButton']")
  WebElement decrementBtn;

  @Autowired
  public Question1Chunk(WebDriver driver) {
    super(driver);
    PageFactory.initElements(_driver, this);
  }





  public boolean isOnPage() {
    return decrementBtn.isDisplayed();
  }

  public void waitForLoad() {
    super.waitForLoad(decrementBtn);
  }
}
