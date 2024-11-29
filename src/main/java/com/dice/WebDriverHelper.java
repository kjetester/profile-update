package com.dice;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverHelper {

  private static volatile RemoteWebDriver driver;

  /**
   * WebDriver singleton.
   *
   * @return driver
   */
  public static WebDriver getDriver() {
    if (driver == null) {
      synchronized (WebDriverHelper.class) {
        if (driver == null) {
          WebDriverManager.chromedriver().clearDriverCache().setup();
          ChromeOptions opts = new ChromeOptions();
//      opts
//          .addArguments("--headless", "--disable-gpu")
//          .setAcceptInsecureCerts(true);
          driver = new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
          driver.manage().window().setSize(new Dimension(1500, 800));
          driver.manage().window().setPosition(new Point(0, 0));
        }
      }
    }
    return driver;
  }

  public static void turnImplicitlyWaitOn() {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }

  public static void turnImplicitlyWaitOff() {
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
  }
}