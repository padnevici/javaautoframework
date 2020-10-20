package com.auto.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "HomePage")
public class HomePage extends AbstractPage {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  QuestionsPage questionsPage;

  @FindBy(xpath = "//a[@data-trackid='landingPage|cta_screenhero']")
  WebElement getOfferButton;

  @Autowired
  public HomePage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(_driver, this);
  }

  public void clickGetOffer() {
    getOfferButton.click();
    questionsPage.getQuestion1Chunk().waitForLoad();
  }

  public boolean isOnPage() {
    return getOfferButton.isDisplayed();
  }

  public void waitForLoad() {
    super.waitForLoad(getOfferButton);
  }
}
