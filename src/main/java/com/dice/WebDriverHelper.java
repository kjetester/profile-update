package com.dice;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverHelper {

  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

  /**
   * WebDriver singleton.
   *
   * @return driver
   */
  public static WebDriver getDriver() {
    if (driver.get() == null) {
      synchronized (WebDriverHelper.class) {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        ChromeOptions opts = new ChromeOptions();
        opts
//          .addArguments("--headless", "--disable-gpu")
            .setAcceptInsecureCerts(true);
        driver.set(new ChromeDriver(opts));
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get().manage().window().setSize(new Dimension(1500, 800));
        driver.get().manage().window().setPosition(new Point(0, 0));
      }
    }
    return driver.get();
  }

  public static void quitDriver() {
    if (driver.get() != null) {
      driver.get().quit();
      driver.remove();
    }
  }

  public static void turnImplicitlyWaitOn() {
    driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }

  public static void turnImplicitlyWaitOff() {
    driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
  }
}