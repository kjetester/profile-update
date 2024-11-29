package com.dice;

import static com.dice.WebDriverHelper.getDriver;

import com.dice.pageObjects.LoginEmailPage;
import com.dice.pageObjects.LoginPasswordPage;
import com.dice.pageObjects.HomeFeedPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UpdateProfileTest {

  Actions actions = new Actions(getDriver());

  @BeforeClass
  public void setUp() {
    getDriver();
  }

  @Test(alwaysRun = true, dataProvider = "credentials")
  public void updateProfile(final String email, final String password) {
    goTo("https://www.dice.com/dashboard/login");
    logIn(email, password);
    openProfilePage();
    editAboutMeSection();
  }

  @AfterClass
  public void TearDown() {
    getDriver().quit();
  }

  @DataProvider
  public static Object[][] credentials() {
    return new Object[][]{
        {"kjtester@icloud.com", "jarvab-waftYv-7xavbi"},
        {"julian.kolodzei@icloud.com", "Power@123"},
        {"wersalife@gmail.com", "xepvoq-4Dobky-kapsyg"}
    };
  }

  private void goTo(final String url) {
    getDriver().get(url);
  }

  private void logIn(final String email, final String password) {
    new LoginEmailPage().enterEmail(email).submitForm();
    new LoginPasswordPage().enterPassword(password).submitForm();
  }

  private void openProfilePage() {
    new HomeFeedPage().clickProfileButton();
  }

  private void editAboutMeSection() {

  }
}