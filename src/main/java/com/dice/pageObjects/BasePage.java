package com.dice.pageObjects;

import static com.dice.WebDriverHelper.getDriver;
import static com.dice.WebDriverHelper.turnImplicitlyWaitOff;
import static com.dice.WebDriverHelper.turnImplicitlyWaitOn;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  protected WebDriver driver;
  protected WebDriverWait wait;
  @FindBy(xpath = "//button[starts-with(@aria-label, 'User')]")
  private WebElement userDropdown;
  @FindBy(id = "loaderDiv")
  protected WebElement loaderCanvas;

  public BasePage() {
    this.driver = getDriver();
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  protected WebElement getClickableElement(final WebElement webElement) {
    turnImplicitlyWaitOff();
    final WebElement element = this.wait.until(elementToBeClickable(webElement));
    turnImplicitlyWaitOn();
    return element;
  }

  protected void waitForAjaxLoader() {
    turnImplicitlyWaitOff();
    this.wait.until(invisibilityOfElementLocated(By.className("ajax-freeze-loader")));
    turnImplicitlyWaitOn();
  }
}
