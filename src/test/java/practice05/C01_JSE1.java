package practice05;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSE1 extends TestBase {

    @Test
    void test() {
        // https://opensource-demo.orangehrmlive.com/ sitesine gidin
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // username: Admin ve password: admin123 girin, Login butonuna tıklayın
        WebElement usernameTextBox = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement passwordTextBox = driver.findElement(By.cssSelector("input[name='password']"));

        usernameTextBox.sendKeys("Admin");
        passwordTextBox.sendKeys("admin123");

         // Typecasting: Veri türünü başka bir türe dönüştürmek.
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement button = driver.findElement(By.tagName("button"));
        waitForSecond(5);

        jse.executeScript("arguments[0].style.backgroundColor = 'black';" , button);
        waitForSecond(5);

        jse.executeScript("arguments[0].style.backgroundColor = 'red';" , button);
        waitForSecond(5);

        jse.executeScript("arguments[0].click();", button);

    }
}

