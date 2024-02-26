package practice03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_LoginTest1 extends TestBase {
    @Test
    void test01() {
        // 1) https://opensource-demo.orangehrmlive.com/ sitesine gidin
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // 2) username: Admin ve password: admin123 girin, Login butonuna tıklayın
        WebElement usernameTextBox = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement passwordTextBox = driver.findElement(By.cssSelector("input[name='password']"));
        WebElement loginButton = driver
                .findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button"));

        usernameTextBox.sendKeys("Admin");
        passwordTextBox.sendKeys("admin123");
        loginButton.click();

        // 3) Sayfaya giriş yapıldığını doğrula
        WebElement dashboardText = driver
                .findElement(By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module"));

        Assertions.assertTrue(dashboardText.isDisplayed(), "Login Test FAILED");
        // 4) Admin butonunun görüdüğünü doğrula
        WebElement adminButton = driver
                .findElement(By.cssSelector(".oxd-text.oxd-text--span.oxd-main-menu-item--name"));
        Assertions.assertTrue(adminButton.isDisplayed());

        // 5) Sayfadan çıkıç yap
        WebElement logoutButton1 = driver
                .findElement(By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon"));
        logoutButton1.click();

        WebElement logoutButton2 = driver
                .findElement(By.xpath("//a[@href='/web/index.php/auth/logout']"));
        logoutButton2.click();

        // 6) Sayfadan Çıkış Yapıldığını Doğrula

        Assertions.assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());
    }
}
