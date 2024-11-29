package com.dice.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginEmailPage extends BasePage {

  @FindBy(name = "email")
  private WebElement emailInput;
  @FindBy(xpath = "//button[@data-testid='sign-in-button']")
  private WebElement submitButton;

  public LoginEmailPage() {
    super();
    PageFactory.initElements(driver, this);
  }

  public LoginEmailPage enterEmail(final String email) {
    super.getClickableElement(this.emailInput).sendKeys(email);
    return this;
  }

  public void submitForm() {
    this.submitButton.click();
  }
}
