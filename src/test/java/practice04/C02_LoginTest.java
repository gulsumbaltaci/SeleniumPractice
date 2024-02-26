package practice04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_LoginTest extends TestBase {

    @Test
    void loginTest() {

        driver.get("https://www.trvlcar.com/");

        // Title: TrvlCar | Premium Car Rental
        // URL: https://www.trvlcar.com/

        Assertions.assertEquals("https://www.trvlcar.com/", driver.getCurrentUrl(), "HATA VAR");
        Assertions.assertEquals("TrvlCar | Premium Car Rental", driver.getTitle(), "HATA VAR");

        WebElement registerButton = driver.findElement(By.xpath("//a[@href=\"/auth\"]"));
        registerButton.click();

        WebElement loginEmailTextBox = driver.findElement(By.xpath("(//input[@name=\"email\"])[1]"));
        loginEmailTextBox.sendKeys("veli@can.com");

        WebElement loginPasswordTextBox = driver.findElement(By.xpath("(//input[@name=\"password\"])[1]"));
        loginPasswordTextBox.sendKeys("Deneme1?");

        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();

        String userName = driver.findElement(By.cssSelector(".dropdown-toggle.nav-link")).getText();

        Assertions.assertEquals("Tonisha Turcotte", userName, "HATA VAR");
    }
}
