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
public class QuestionsPage extends AbstractPage {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @FindBy(xpath = "//button[@data-testid='stepperButton']")
  WebElement continueBtn;

  @Autowired
  private Question1Chunk question1Chunk;

  @Autowired
  private Question2Chunk question2Chunk;

  @Autowired
  public QuestionsPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(_driver, this);
  }

  public Question1Chunk getQuestion1Chunk() {
    return question1Chunk;
  }

  public Question2Chunk getQuestion2Chunk() {
    return question2Chunk;
  }


  public void clickContinue() {
    continueBtn.click();

  }
//
//  public boolean isOnPage() {
//    return getOfferButton.isDisplayed();
//  }
//
//  public void waitForLoad() {
//    super.waitForLoad(getOfferButton);
//  }
}
