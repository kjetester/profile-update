package com.dice;

import static com.dice.WebDriverHelper.getDriver;
import static com.dice.WebDriverHelper.quitDriver;

import com.dice.pageObjects.LoginEmailPage;
import com.dice.pageObjects.LoginPasswordPage;
import com.dice.pageObjects.HomeFeedPage;
import java.util.List;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UpdateProfileTest {

  Actions actions = new Actions(getDriver());

  @BeforeMethod
  public void setUp() {
    getDriver();
  }

  @Test(alwaysRun = true, dataProvider = "credentials")
  public void updateProfile(final String email, final String password) {
    System.out.println("Thread: " + Thread.currentThread().threadId() + " Data: " + List.of(email, password));
    goToLoginPage();
    logIn(email, password);
    openProfilePage();
    editAboutMeSection();
  }

  @AfterMethod
  public void TearDown() {
    quitDriver();
  }

  @DataProvider(parallel = true)
  public static Object[][] credentials() {
    return new Object[][]{
        {"kjtester@icloud.com", "jarvab-waftYv-7xavbi"},
        {"julian.kolodzei@icloud.com", "Power@123"},
        {"wersalife@gmail.com", "xepvoq-4Dobky-kapsyg"}
    };
  }

  private void goToLoginPage() {
    getDriver().get("https://www.dice.com/dashboard/login");
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