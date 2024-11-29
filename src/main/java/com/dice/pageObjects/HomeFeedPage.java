package com.dice.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeFeedPage extends BasePage {

  @FindBy(id = "profileLink")
  private WebElement profileButton;

  public HomeFeedPage() {
    super();
    PageFactory.initElements(driver, this);
  }

  public ProfilePage clickProfileButton() {
    super.waitForAjaxLoader();
    super.getClickableElement(profileButton).click();
    return new ProfilePage();
  }
}