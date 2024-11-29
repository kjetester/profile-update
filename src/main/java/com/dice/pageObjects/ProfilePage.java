package com.dice.pageObjects;

import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {

  public ProfilePage() {
    super();
    PageFactory.initElements(driver, this);
  }
}