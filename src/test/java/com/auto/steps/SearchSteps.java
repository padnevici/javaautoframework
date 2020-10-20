package com.auto.steps;

import com.auto.ContextConfigurator;
import com.auto.page.objects.HomePage;
import com.auto.page.objects.QuestionsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class SearchSteps {

  @Autowired
  private HomePage homePage;

  @Autowired
  private QuestionsPage questionsPage;

  @Autowired
  private ApplicationContext context;

  @Given("user is on Home page")
  public void userIsNavigatedToHomePage() {
    homePage.waitForLoad();
    Assert.assertTrue(homePage.isOnPage());
  }

  @When("user search by")
  public void userSearchBy() {
    RestAssured.baseURI = "https://gorest.co.in/public-api";
    RestAssured.given().when().get("/posts").then().assertThat().statusCode(200);
  }

  @Then("first result has following link")
  public void firstResultHasFollowingLink() {

  }

  @When("user clicks on get offer button")
  public void userClicksOnGetOfferButton() {
    homePage.clickGetOffer();
  }

  @Then("user is on Questionary - Question1 page")
  public void userIsOnQuestionaryPage() {
    questionsPage.getQuestion1Chunk().waitForLoad();
    Assert.assertTrue(questionsPage.getQuestion1Chunk().isOnPage());
  }

  @Then("user is on Questionary - Question2 page")
  public void userIsOnQuestionaryQuestionPage() {
    questionsPage.getQuestion2Chunk().waitForLoad();
    Assert.assertTrue(questionsPage.getQuestion2Chunk().isOnPage());
  }

  @When("user set family composition")
  public void userSetFamilyComposition(DataTable table) {
    int countOfChildren = Integer.parseInt(table.asMaps().get(0).get("children"));
    questionsPage.getQuestion2Chunk().setChildren(countOfChildren);
  }

  @When("user continues wizard")
  public void userContinuesWizard() {
    questionsPage.clickContinue();
  }
}
