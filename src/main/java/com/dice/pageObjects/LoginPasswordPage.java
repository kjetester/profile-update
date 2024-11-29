package com.dice.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPasswordPage extends BasePage {

  @FindBy(name = "password")
  private WebElement passwordInput;
  @FindBy(xpath = "//button[@data-testid='submit-password']")
  private WebElement submitButton;

  public LoginPasswordPage() {
    super();
    PageFactory.initElements(driver, this);
  }

  public LoginPasswordPage enterPassword(final String password) {
    super.getClickableElement(passwordInput).sendKeys(password);
    return this;
  }

  public void submitForm() {
    this.submitButton.click();
  }
}
