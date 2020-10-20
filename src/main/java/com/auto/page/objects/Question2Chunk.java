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
public class Question2Chunk extends AbstractPage {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @FindBy(xpath = "//div[div[label[@for='CHILDREN']]]/button[@data-testid='incrementButton']")
  WebElement childrenIncrementBtn;

  @FindBy(xpath = "//div[div[label[@for='CHILDREN']]]/button[@data-testid='decrementButton']")
  WebElement childrenDecrementBtn;

  @FindBy(name = "CHILDREN")
  WebElement childrenInput;

  @Autowired
  public Question2Chunk(WebDriver driver) {
    super(driver);
    PageFactory.initElements(_driver, this);
  }

  public void setChildren(int countOfChildren) {
    int actualCount = getCountOfChildren();

    while (actualCount < countOfChildren) {
      childrenIncrementBtn.click();
      actualCount = getCountOfChildren();
    }
    while (actualCount > countOfChildren) {
      childrenDecrementBtn.click();
      actualCount = getCountOfChildren();
    }
  }

  public int getCountOfChildren() {
    return Integer.parseInt(childrenInput.getAttribute("value"));
  }

  public boolean isOnPage() {
    return childrenIncrementBtn.isDisplayed();
  }

  public void waitForLoad() {
    super.waitForLoad(childrenIncrementBtn);
  }
}
